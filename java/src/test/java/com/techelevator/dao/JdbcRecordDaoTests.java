package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Record;
import com.techelevator.model.RecordDTO;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class JdbcRecordDaoTests extends BaseDaoTests{

    private static final Record RECORD_1 = new Record("1353040","Kind of Blue", "I like this", "Good");
    private static final Record RECORD_2 = new Record("1486272","Nashville Skyline", "I like this", "Good");
    private static final Record RECORD_3 = new Record("498868","Harvest", "I like this", "Good");
    private static final Record RECORD_4 = new Record("1353040","Kind of Blue", "I like this", "Good");
    private static final User USER_1 = new User(1001, "user1", "user1", "ROLE_USER", false);
    private static final Collection COLLECTION_1 = new Collection(104, 1001, "USER", false, Arrays.asList("1353040","1486272", "498868","1353040"));


    private static final RecordDTO RECORD_DTO_1 = new RecordDTO();
    private static final RecordDTO RECORD_DTO_2 = new RecordDTO();
    private static final RecordDTO RECORD_DTO_3 = new RecordDTO();




    private Record updatedrecord;
    private JdbcRecordDao sut;

    public Record record;


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcRecordDao(jdbcTemplate);
    }

    @Test
    public void get_record_by_id_returns_correct_record(){
        Record test_record_1 = sut.getRecordById("1353040");
        Record test_record_2 = sut.getRecordById("498868");
        assertRecordsMatch(RECORD_1, test_record_1);
        assertRecordsMatch(RECORD_2, test_record_2);
    }

    @Test
    public void get_user_library_returns_complete_library(){
        List<Record> test_library_1 = sut.getUserLibrary(1001);
        Assert.assertEquals(4, test_library_1.size());

    }

    @Test
    public void create_tags_creates_tags_with_correct_value(){
        RecordDTO recordDTO = new RecordDTO();
       sut.createTags(RECORD_1, "Jazz Metal");
      recordDTO.setTags("Jazz Metal);

                Assert


    }


    private void assertRecordsMatch(Record expected, Record actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getTitle(),actual.getTitle());
        Assert.assertEquals(expected.getUserNote(),actual.getUserNote());
        Assert.assertEquals(expected.getCondition(),actual.getCondition());

    }





}
