package CSCI5308.GroupFormationTool.CoursesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Reader;
import java.util.List;

import org.junit.jupiter.api.Test;

class StudentCSVParserTest {
	@Test
	public void parseCSVFile() {
		Reader reader = null;
		CSVReaderMock csvReader = new CSVReaderMock();
		List<String[]> records = csvReader.readAll(reader);
		assertThat(records).isNotNull();
		assertThat(records).isNotEmpty();
		assertTrue(records.size() > 0);
	}
}