package md.eavertizare.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import md.eavertizare.model.Client;

public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<Client> listClients = (List<Client>) model.get("listClients");

		doc.add(new Paragraph("Report of clients"));
		doc.addCreationDate();
		


		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 3.0f, 2.0f, 1.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("First name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Last name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Phone number", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Email", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Expiration date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Sent", font));
		table.addCell(cell);

		// write table row data
		for (Client client : listClients) {
			table.addCell(client.getFirstName());
			table.addCell(client.getLastName());
			table.addCell(String.valueOf(client.getPhoneNumber()));
			table.addCell(client.getEmail());
			table.addCell(String.valueOf(client.getExpirationDate()));
			table.addCell(String.valueOf(client.isSent()));
		}

		doc.add(table);

	}

}