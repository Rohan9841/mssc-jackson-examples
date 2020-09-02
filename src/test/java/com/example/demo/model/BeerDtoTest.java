package com.example.demo.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
public class BeerDtoTest extends BaseTest {

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testSerializeDto() throws JsonProcessingException {
		BeerDto beerDto = getDto();
		String jsonString = objectMapper.writeValueAsString(beerDto);
		System.out.println(jsonString);
	}

	@Test
	void testDeserialize() throws JsonProcessingException {
		String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":123123123,\"price\":\"12.99\","
				+ "\"createdDate\":\"2020-09-02T16:07:48-0400\",\"lastUpdatedDate\":\"2020-09-02T16:07:48.9394462-04:00\","
				+ "\"myLocalDate\":\"20200902\",\"beerId\":\"be88e6f6-00d0-4dec-b61e-2e1fe880946f\"}";
		BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
		System.out.println(beerDto);
	}
}
