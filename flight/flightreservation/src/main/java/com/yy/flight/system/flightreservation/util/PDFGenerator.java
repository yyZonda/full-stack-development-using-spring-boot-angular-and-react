package com.yy.flight.system.flightreservation.util;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yy.flight.system.flightreservation.entities.Reservation;
import com.itextpdf.text.Document;
import com.yy.flight.system.flightreservation.service.ReservationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    public void genarateItinerary(Reservation reservation,String filePath){
        LOGGER.info("genarateItinerary()");
        Document document=new Document();
        try {
            PdfWriter.getInstance(document,new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();
        } catch (DocumentException e) {
            LOGGER.error("Exception in genarateItinerary()"+e);
        } catch (FileNotFoundException e) {
            LOGGER.error("Exception in genarateItinerary()"+e);
        }
    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable table = new PdfPTable(2);

        PdfPCell cell;
        cell = new PdfPCell((new Phrase("FLight Itinerary")));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell((new Phrase("FLight Details")));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Departure Date");
        table.addCell(String.valueOf(reservation.getFlight().getDateOfDeparture()));

        cell = new PdfPCell((new Phrase("Passenger Details")));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirstName());

        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLastName());

        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());
        return table;
    }
}
