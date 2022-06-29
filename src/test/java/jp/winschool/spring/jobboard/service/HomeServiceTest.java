package jp.winschool.spring.jobboard.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jp.winschool.spring.jobboard.model.Offer;
import jp.winschool.spring.jobboard.repository.OfferRepository;

@SpringJUnitConfig
class HomeServiceTest {
	@TestConfiguration
	static class Config {
		@Bean
		public HomeService homeService() {
			return new HomeService();
		}
	}
	
	@Autowired
	private HomeService homeService;
	
	@MockBean
	private OfferRepository offerRepository;
	
	@Test
	public void testGetOfferList() {
		List<Offer> offers = homeService.getOfferList();
		verify(offerRepository).findByActiveTrue();
	}
	
	@Test
	public void testFindOfferList() {
		String word = "Spring";
		String prefecture = "東京都";
		
		List<Offer> offers = homeService.findOfferList(word, prefecture);
		
		verify(offerRepository).findByActiveTrueAndTitleContainsAndPrefectureContains(word, prefecture);
	}

}
