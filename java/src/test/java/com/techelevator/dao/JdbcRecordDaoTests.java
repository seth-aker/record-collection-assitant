package com.techelevator.dao;
import com.techelevator.model.Collection;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;


public class JdbcRecordDaoTests extends BaseDaoTests {


    private static final Record DUMMY_RECORD_1 = new Record("1353040", "Kind of Blue", "I like this", "Good");
    private static final Record DUMMY_RECORD_2 = new Record("1486272", "Nashville Skyline", "I like this", "Good");
    private static final Record DUMMY_RECORD_3 = new Record("498868", "Harvest", "I like this", "Good");
    private static final Record DUMMY_RECORD_4 = new Record("372778", "Sgt. Peppers Lonely Hearts Club Band", "I like this", "Good");
    private static final Record DUMMY_RECORD_5 = new Record("168314", "Songs In The Key Of Life", "I like this", "Good");

    private static final Collection DUMMY_COLLECTION_1 = new Collection(101, 1001, "USER", false, Arrays.asList("1353040", "1486272", "498868", "1353040"));
    private static final Collection DUMMY_COLLECTION_2 = new Collection(104, 1001, "USER", false, Arrays.asList("1353040", "1486272", "498868", "1353040"));

    private static RecordDTO RECORD_DTO_5 = new RecordDTO();
    private static RecordDTO RECORD_DTO_6 = new RecordDTO();
    private static Record dumbestRecord = new Record();

    private JdbcRecordDao sut;

    private Record testRecord;


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcRecordDao(jdbcTemplate);


        testRecord = new Record(
                "12345",
                "Jettison Mind Hatch",
                "This music sounds like an upset stomach",
                "Far Out");
    }

    @Test
    public void getRecordById_returns_correct_record() {





     Record record = sut.getRecordById("1486272");
        System.out.println(record.getTitle());

        record = sut.getRecordById("498868");
        Assert.assertEquals(DUMMY_RECORD_3.getTitle(), record.getTitle());

        record = sut.getRecordById("372778");
        Assert.assertEquals(DUMMY_RECORD_4.getTitle(), record.getTitle());

    }

    @Test
    public void getUserLibrary_returns_complete_library() {
        List<Record> test_library = sut.getUserLibrary(1001);
        Assert.assertEquals(4, test_library.size());

      test_library = sut.getUserLibrary(1002);
        Assert.assertEquals(13, test_library.size());

       test_library = sut.getUserLibrary(1003);
        Assert.assertEquals(0, test_library.size());
    }

    @Test
    public void createRecord_creates_correct_record() {
    boolean result = sut.createRecord(testRecord);
    Assert.assertTrue(result);

   Record record = sut.getRecordById(testRecord.getId());
   assertRecordsMatch(testRecord, record);
    }

    @Test
    public void addRecordToUserLib_adds_record(){
     boolean result = sut.addRecordToUserLib(DUMMY_RECORD_5, 1001);
        Assert.assertTrue(result);

        result = sut.addRecordToUserLib(DUMMY_RECORD_5, 1003);
        Assert.assertTrue(result);

    }
    @Test
    public void updateCondition_has_expected_values_when_retrieved(){
        boolean result = sut.updateCondition("1353040","Cracked", 1001);
        Assert.assertTrue(result);

        dumbestRecord = sut.getRecordById("1353040");
       Assert.assertEquals(dumbestRecord.getCondition(), "Cracked");

        result = sut.updateCondition("1353040","", 1001);
        Assert.assertTrue(result);

        dumbestRecord = sut.getRecordById("1353040");
        Assert.assertEquals(dumbestRecord.getCondition(), "");
    }

    @Test
    public void updateRecordNote_updates_correct_note(){
        boolean result = sut.updateRecordNote("1353040", 1001,"I cried, I laughed, I tee-heed.");
        Assert.assertTrue(result);

        dumbestRecord = sut.getRecordById("1353040");
        Assert.assertEquals("I cried, I laughed, I tee-heed.", dumbestRecord.getUserNote());

        result = sut.updateRecordNote("1353040", 1001,"");
        Assert.assertTrue(result);

        dumbestRecord = sut.getRecordById("1353040");
        Assert.assertEquals(dumbestRecord,"");
    }

    @Test
    public void removeRecordFromUserLibrary(){
        int originalLibraryCount = sut.getUserLibrary(1001).size();
        boolean result = sut.removeRecordFromUserLib(DUMMY_RECORD_1, 1001);
        int newLibraryCount = sut.getUserLibrary(1001).size();
        Assert.assertTrue(result);
        Assert.assertEquals(originalLibraryCount - 1, newLibraryCount);
    }



    private void assertRecordsMatch(Record expected, Record actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.getUserNote(), actual.getUserNote());
        Assert.assertEquals(expected.getCondition(), actual.getCondition());
    }

    public RecordDTO mapRowToRecordDTO(Record record) {
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setTitle(record.getTitle());
        recordDTO.setUserNotes(record.getUserNote());
        recordDTO.setCondition(record.getCondition());
        String idString = record.getId();
        if (idString != null && !idString.isEmpty()) {
            try {
                int id = Integer.parseInt(idString);
                recordDTO.setId(id);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid ID format:" + idString);
            }
        } else {
            throw new IllegalArgumentException("ID is missing or empty");
        }
        return recordDTO;
    }
}


