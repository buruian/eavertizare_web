package md.eavertizare.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import md.eavertizare.model.Client;

public class MyExcelUtil {
	

	public static List<Client> readClientsFromExcelFile(MultipartFile file) throws IOException, ParseException {

		List<Client> listClients = new ArrayList<>();
		Workbook workbook = null; // new HSSFWorkbook(file.getInputStream());

		String[] extension = { "xls" };
		if (FilenameUtils.isExtension(file.getOriginalFilename(), extension)) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		if (file.getOriginalFilename().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		}

		// Workbook workbook = new XSSFWorkbook(file.getInputStream());
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		int i = 0;
		Client client = null;
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

		while (iterator.hasNext()) {

			if (i > 0) {
				client = new Client();
			}

			Row row = iterator.next();
			// Row row = rowIterator.next(); // Read Rows from Excel

			Iterator<Cell> cellIterator = row.cellIterator();// Read

			while (cellIterator.hasNext()) {
				cellIterator.next();
				if (i > 0) {

					String dateExcel = row.getCell(5).getStringCellValue();
					Date date = df1.parse(dateExcel);

					// Sets the Read data to the model class
					client.setFirstName(row.getCell(1).getStringCellValue());
					client.setLastName(row.getCell(2).getStringCellValue());
					client.setPhoneNumber((int) row.getCell(3).getNumericCellValue());
					client.setEmail(row.getCell(4).getStringCellValue());
					client.setExpirationDate(date);

					// persist data into database in here

				}

			}
			i++;
			if (client != null) {
				listClients.add(client);
			}

		}

		workbook.close();
		// inputStream.close();

		return listClients;
	}

}
