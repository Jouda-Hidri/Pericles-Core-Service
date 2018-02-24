package pericles.coreservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pericles.coreservice.api.VoteController;
import pericles.coreservice.domain.Candidate;
import pericles.coreservice.service.VoteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoteControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private VoteController controller;

	@Mock
	VoteService service;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test that the GET request to "/vote/{voter}/for/{candidate}"
	 * {@link pericles.coreservice.api.VoteController#vote(long, long)} returns the
	 * correct status
	 */
	@Test
	public void testVote() throws Exception {
		int voter = 1;
		int candidate = 1;
		// TODO add test case when voter or candidate doesn't exist in database
		this.mockMvc.perform(get("/vote/{voter}/for/{candidate}", voter, candidate)).andExpect(status().isOk());
	}

	/**
	 * Test that the GET request to "/result"
	 * {@link pericles.coreservice.api.VoteController#getResult()} returns the
	 * correct status
	 */
	@Test
	public void testGetResult() throws Exception {
		List<Candidate> listCandidates = new ArrayList<Candidate>();
		listCandidates.add(new Candidate("Han", "Solo"));
		listCandidates.add(new Candidate("Darth", "Vader"));

		when(service.getListCandidates()).thenReturn(listCandidates);

		// TODO test the return

		this.mockMvc.perform(get("/result")).andExpect(status().isOk());
	}

}
