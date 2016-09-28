package secquiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class ReadCSVtoXLSX {
	static List<QuestionBeanMath> allMathBeans = new ArrayList<QuestionBeanMath>();
	public static void main(String[] args) throws IOException{
		File data = new File("data");
		String subject = null;
		ArrayList<String> listOfFiles = getFilesBySubject(data, subject);
		
		String fileSubject;
		//int i=1;
		for (String file : listOfFiles) {
			//System.out.println(file);
			fileSubject = file.substring(5, 9);			
			//System.out.println(fileSubject);
			if (fileSubject.equals("math")) {
				//System.out.println(fileSubject + i);
				try {
					readWithCsvBeanReader(file);
					//i++;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Size = " + allMathBeans.size());
		System.out.println("Starting writing ...");
		
		FileInputStream input = new FileInputStream("mathq.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sh = wb.getSheetAt(0);
		int j = 1;
		
		for (QuestionBeanMath beanMath : allMathBeans) {
			Row row = sh.createRow(j++);
			
			String val1 = beanMath.getSousQuestion1();
			String val2 = beanMath.getSousQuestion2();
			//System.out.println("Reponses = " + val);
			System.out.println("Q " + beanMath.getId_question() + " sousqst1 = " + isNull(val1) + "; sousquest2 = " + isNull(val2));
			//System.out.println("MaxReponses = " + countMaxReponses(beanMath));
			int k = 0;
			row.createCell(k++).setCellValue(getQuestComplete(beanMath));
			row.createCell(k++).setCellValue(countMaxReponses(beanMath));
			row.createCell(k++).setCellValue(beanMath.getA());
			row.createCell(k++).setCellValue(beanMath.getB());
			row.createCell(k++).setCellValue(beanMath.getC());
			row.createCell(k++).setCellValue(beanMath.getD());
			row.createCell(k++).setCellValue(beanMath.getReponse().toUpperCase());
			row.createCell(k++).setCellValue(getQuestType(beanMath));
			row.createCell(k++).setCellValue(1);
			row.createCell(k++).setCellValue(beanMath.getExplication());
		}
		
		FileOutputStream output = new FileOutputStream("mathq.xlsx");
		System.out.println("writting ... ");
		wb.write(output);
		output.close();

		wb.close();
		
		System.out.println("end");
	}
	
	private static ArrayList<String> getFilesBySubject (final File folder, String subject){
		ArrayList<String> listOfFiles = new ArrayList<String>();		
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				getFilesBySubject(fileEntry, subject);
			} else {
				listOfFiles.add(folder + "\\" + fileEntry.getName());
			}
		}
		if (listOfFiles.isEmpty()) {
			System.out.println("No files in folder!");
		}
		return listOfFiles;		
	}
	
	/**
	 * Sets up the processors used for the examples. There are 10 CSV columns, so 10 processors are defined. Empty
	 * columns are read as null (hence the CustomOptional() for mandatory columns).
	 * 
	 * @return the cell processors
	 */
	private static CellProcessor[] getProcessorsMath() {
		
	        final CellProcessor[] processors = new CellProcessor[] { 
	                new ParseInt(), //id_question	
	                new ParseInt(), //id_question
	                new ParseInt(), //typeQuest
	                new CustomOptional(), // question
	                new CustomOptional(), //sousQuestion1
	                new CustomOptional(), //sousQuestion2
	                new CustomOptional(), //a
	                new CustomOptional(), //b
	                new CustomOptional(), //c
	                new CustomOptional(), //d
	                new CustomOptional(), //reponse
	                new CustomOptional(), //explication
	                new CustomOptional(), //sujets_traites	                
	        };
	        
	        return processors;
	}
	
	private static CellProcessor[] getProcessorsOther() {
		
        final CellProcessor[] processors = new CellProcessor[] { 
                new ParseInt(), //id_question                
                new ParseInt(), //typeQuest
                new CustomOptional(), // question
                new CustomOptional(), //sousQuestion1
                new CustomOptional(), //sousQuestion2
                new CustomOptional(), //a
                new CustomOptional(), //b
                new CustomOptional(), //c
                new CustomOptional(), //d
                new CustomOptional(), //e
                new CustomOptional(), //reponse
                new CustomOptional(), //explication
                new CustomOptional(), //sujets_traites	                
        };
        
        return processors;
}
	
	/**
	 * An example of reading using CsvBeanReader.
	 */
	private static void readWithCsvBeanReader(String fileName) throws Exception {
	        
	        ICsvBeanReader beanReader = null;
	        try {
	                beanReader = new CsvBeanReader(new FileReader(fileName), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
	                
	                // the header elements are used to map the values to the bean (names must match)
	                final String[] header = beanReader.getHeader(true);
	                final CellProcessor[] processors = getProcessorsMath();
	                
	                QuestionBeanMath mathQ;
	                while( (mathQ = beanReader.read(QuestionBeanMath.class, header, processors)) != null ) {
	                        //System.out.println(String.format("lineNo=%s, rowNo=%s, question=%s", beanReader.getLineNumber(),
	                                //beanReader.getRowNumber(), question));
	                	//System.out.println("Q " + mathQ.getId_question() + ": " + mathQ.getQuestion() + " reponse: " + mathQ.getReponse());
	                	allMathBeans.add(mathQ);
	                }
	                
	        }
	        finally {
	                if( beanReader != null ) {
	                        beanReader.close();	                        
	                }
	        }
	}
	
	private static boolean isNull(String s)
	{
	  return (s==null);
	}
	
	private static int countMaxReponses (QuestionBeanMath question) {
		int number = 0;		
		if (!(isNull(question.getA()))) number++ ;
		if (!(isNull(question.getB()))) number++ ;
		if (!(isNull(question.getC()))) number++ ;
		if (!(isNull(question.getD()))) number++ ;
		if (number == 0) number = 1;
		return number;		
	}
	
	private static int getQuestType(QuestionBeanMath question) {
		int nr = countMaxReponses(question);		
		switch (nr) {
		case 1 :
			return 4;
		case 2 :
			return 2;
		case 3 : case 4 : 
			return 0;
		}
		return -1;				
	}
	
	private static String getQuestComplete (QuestionBeanMath question) {
		String quest;
		
		quest = question.getQuestion();
		if (!(isNull(question.getSousQuestion1()))) {
			quest += " " + question.getSousQuestion1();
		}			
		if (!(isNull(question.getSousQuestion2()))) {
			quest += " " + question.getSousQuestion2();
		}			
		return quest;
		
	}
	
}
