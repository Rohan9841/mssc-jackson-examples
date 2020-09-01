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
		String json = "{\"id\":\"0d8b5cee-619f-47ab-a710-c800d914920b\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\","
				+ "\"upc\":123123123,\"price\":12.99,\"createdDate\":\"2020-09-01T19:50:26.094228-04:00\","
				+ "\"lastUpdatedDate\":\"2020-09-01T19:50:26.0962236-04:00\"}";
		BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
		System.out.println(beerDto);
	}
}
