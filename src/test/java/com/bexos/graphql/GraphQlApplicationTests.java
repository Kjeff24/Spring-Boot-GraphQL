package com.bexos.graphql;

import com.bexos.graphql.controllers.BookingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookingController.class)
class GraphQlApplicationTests {

	@Autowired
	private GraphQlTester graphQlTester;

	@Test
	void shouldGetFirstBook() {
		this.graphQlTester
				.documentName("bookDetails")
				.variable("id", "book-1")
				.execute()
				.path("bookById")
				.matchesJson("""
                    {
                        "id": "book-1",
                        "name": "Effective Java",
                        "pageCount": 416,
                        "author": {
                          "firstName": "Joshua",
                          "lastName": "Bloch"
                        }
                    }
                """);
	}

}
