package com.jaxb.app;

import com.eswari.srp.neonatal.delivery.v2_0.ConfigRx;
import com.eswari.srp.neonatal.delivery.v2_0.CycleType;
import com.eswari.srp.neonatal.delivery.v2_0.CycleVersion;
import com.eswari.srp.neonatal.delivery.v2_0.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.StringWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JaxBMarshallerApp {
    private static String PAT_DETAIL_STR = "This is pat detail contents";
    private static String XRAY_BIN_STR = "This is xray bin contents";
    private static String SUMMARY_XML_STR = "This is summary xml contents";

    public static void main(String[] args) {
        ConfigRx configRx = new ConfigRx();
        configRx.setFormatVersion((byte) 2);
        configRx.setCycleType(CycleType.SPRING);
        configRx.setContentVersion(25);
        configRx.setConnectedHealthId("DemoConnectedHealthId");
        configRx.setCycleVersion(CycleVersion.V3_0);
        configRx.setPatientId("DemoPatient");
        configRx.setProviderId("DemoProvider");
        configRx.setPatDetail(PAT_DETAIL_STR.getBytes(UTF_8));
        configRx.setXrayBin(XRAY_BIN_STR.getBytes(UTF_8));
        configRx.setSummaryXml(SUMMARY_XML_STR.getBytes(UTF_8));

        String xml = generateRxContentXml(configRx);
        System.out.println(xml);
    }

    private static String generateRxContentXml(ConfigRx configRx) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
            StringWriter w = new StringWriter();
            ctx.createMarshaller().marshal(configRx, w);
            return w.toString();
        } catch (JAXBException ex) {
            throw new IllegalStateException("Error during marshalling", ex);
        }
    }
}
