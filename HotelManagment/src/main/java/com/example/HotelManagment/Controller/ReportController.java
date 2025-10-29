package com.example.HotelManagment.Controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {

    private final DataSource dataSource;

    public ReportController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private ResponseEntity<byte[]> generatePdf(String jasperFileName, String downloadFileName) throws Exception {
        // Jasper file must be in src/main/resources/reports/
        InputStream jasperStream = getClass().getResourceAsStream("/reports/" + jasperFileName);
        if (jasperStream == null) {
            throw new RuntimeException("Jasper file not found: " + jasperFileName);
        }

        // Fill report using database connection
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, new HashMap<String, Object>(), dataSource.getConnection());

        // Export to PDF
        byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", downloadFileName);

        return ResponseEntity.ok().headers(headers).body(pdf);
    }

    @GetMapping("/monthly-revenue")
    public ResponseEntity<byte[]> monthlyRevenue() throws Exception {
        return generatePdf("monthly_revenue.jasper", "MonthlyRevenue.pdf");
    }

    @GetMapping("/occupancy-rate")
    public ResponseEntity<byte[]> occupancyRate() throws Exception {
        return generatePdf("occupancy_rate.jasper", "OccupancyRate.pdf");
    }

    @GetMapping("/top-booked-rooms")
    public ResponseEntity<byte[]> topBookedRooms() throws Exception {
        return generatePdf("top_booked_rooms.jasper", "TopBookedRooms.pdf");
    }

    @GetMapping("/guest-frequency")
    public ResponseEntity<byte[]> guestFrequency() throws Exception {
        return generatePdf("guest_frequency.jasper", "GuestFrequency.pdf");
    }
}
