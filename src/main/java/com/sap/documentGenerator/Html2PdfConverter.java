package com.sap.documentGenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
public class Html2PdfConverter {

    private Html2PdfConverter() {
    }
    
    public static void main(String[] arg){
    	String html = "<html><p>I042416</p></html>";
    	try {
			byte[] content = convert(html);
			System.out.println("PDF size: " + content.length);
			FileOutputStream fileOuputStream = new FileOutputStream("C:\\temp\\1.pdf"); 
			fileOuputStream.write(content);
			fileOuputStream.close();
		} catch (InvocationTargetException | IOException e) {
			e.printStackTrace();
		}
    }

    public static byte[] convert(String html) throws InvocationTargetException {
        ITextRenderer renderer = new ITextRenderer();

        try {
            renderer.setDocumentFromString(html);
        } catch (Exception e) {
            System.out.println("there's may be something wrong with formdata or template");
        }

        renderer.layout();

        byte[] byteArr = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            renderer.createPDF(os);
            byteArr = os.toByteArray();
            os.close();
        } catch (IOException | DocumentException e) {
            System.out.println("IO Exception occurred");
        }
        return byteArr;
    }
}
