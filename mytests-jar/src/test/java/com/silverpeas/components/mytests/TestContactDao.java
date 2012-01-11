package com.silverpeas.components.mytests;

import com.silverpeas.components.mytests.dao.ContactDAO;
import com.silverpeas.components.mytests.model.Contact;
import com.silverpeas.components.mytests.service.MyTestsServicesLocator;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestContactDao {

    private static ContactDAO dao;
    private static ClassPathXmlApplicationContext context;
    private static ReplacementDataSet dataSet;
    private static DatabaseConnection connection;

    public TestContactDao() {
    }

    @BeforeClass
    public static void generalSetUp() throws IOException, NamingException,
            Exception {
        context = new ClassPathXmlApplicationContext("spring-mytests.xml");
        dao = context.getBean(ContactDAO.class);
        DataSource ds = (DataSource) context.getBean("dataSource");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        FlatXmlDataSet idataSet = builder
                .build(TestContactDao.class
                        .getClassLoader()
                        .getResourceAsStream(
                                "com/silverpeas/components/mytests/dao/mytests-dataset.xml"));

        dataSet = new ReplacementDataSet(idataSet);
        dataSet.addReplacementObject("[NULL]", null);
        connection = new DatabaseConnection(ds.getConnection());
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        context.close();
    }

    @Before
    public void before() throws DatabaseUnitException, SQLException {
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    @Test
    public void testFindContact() throws Exception {
        int id = 1;
        Contact dbContact = dao.findOne(id);
        Assert.assertEquals("Bart", dbContact.getFirstName());

        //FIXME supprimer cette ligne
        MyTestsServicesLocator.getInstance().getMyTestsService().getMyContacts();
    }

    @Test
    public void testSaveAndFindAllContacts() throws Exception {
        List<Contact> dbContacts = dao.findAll();
        Assert.assertEquals(2, dbContacts.size());

        Contact newContact = new Contact("Nicolas", "Dupont", "R&D", "1");
        dao.saveAndFlush(newContact);

        dbContacts = dao.findAll();
        Assert.assertEquals(3, dbContacts.size());
    }

    @Test
    public void testFindNotExistingContact() throws Exception {
        int id = 3;
        Contact dbContact = dao.findOne(id);
        Assert.assertNull(dbContact);
    }

    @Test
    public void testDeleteAndFindAllContacts() throws Exception {
        List<Contact> dbContacts = dao.findAll();
        Assert.assertEquals(2, dbContacts.size());

        dao.delete(2);

        dbContacts = dao.findAll();
        Assert.assertEquals(1, dbContacts.size());
    }

    @Test
    public void testUpdateContact() throws Exception {
        int id = 1;
        Contact dbContact = dao.findOne(id);
        Assert.assertEquals("Bart", dbContact.getFirstName());

        dbContact.setFirstName("Homer");
        dao.save(dbContact);

        dbContact = dao.findOne(id);
        Assert.assertEquals("Homer", dbContact.getFirstName());
    }

}
