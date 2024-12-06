# JAXBMarshaller
Purpose of this program is to generate XML string from XSD using jaxb marshaller.<br>
1. Generate Java Pojo classes from XSD using generate sources maven feature.
2. Populate Data in the generated Pojo class object which represents the root in XSD.
3. Create Marshaller from JAXBContext and run marshal on the marshaller to get XML string from the Data filled pojo. 

### Sample Output 
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:config-rx format-version="2" xmlns:ns2="http://eswari.com/srp/neonatal/delivery/v2_0">
   <content-version>25</content-version>
   <connected-health-id>DemoConnectedHealthId</connected-health-id>
   <provider-id>DemoProvider</provider-id>
   <patient-id>DemoPatient</patient-id>
   <cycle-type>Spring</cycle-type>
   <cycle-version>3.0</cycle-version>
   <pat-detail>VGhpcyBpcyBwYXQgZGV0YWlsIGNvbnRlbnRz</pat-detail>
   <xray-bin>VGhpcyBpcyB4cmF5IGJpbiBjb250ZW50cw==</xray-bin>
   <summary-xml>VGhpcyBpcyBzdW1tYXJ5IHhtbCBjb250ZW50cw==</summary-xml>
</ns2:config-rx>
```
