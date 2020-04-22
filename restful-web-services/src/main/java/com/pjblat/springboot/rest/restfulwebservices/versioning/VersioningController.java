package com.pjblat.springboot.rest.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController
{
	/*
	 * Factors in deciding which type of versioning to use
	 * - URI Pollution.  URI and Params methods make the URI's messy.
	 * - Misuse of HTTP headers by #3 and #4.  never intended for this purpose.
	 * - Caching.  caching can never be used when using headers for versioning.
	 * - Executing requests from browser?  If using a headers approach, can't execute the APIs on browser.
	 * - API Documentation - how does each get documented?  URI and params is easy because code gen can document.
	 */
	
	/*
	 * One way of versioning using different URIs for different versions.
	 */
	@GetMapping("/v1/person")	
	public PersonV1 personV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2()
	{
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	/*
	 * Second way of versioning using a request param to differentiate versions
	 */
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2()
	{
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	/*
	 * Third way of versioning using a header param to differentiate versions
	 */
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2()
	{
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	/*
	 * Fourth way of versioning using a producer to differentiate versions
	 * MIME-TYPE versioning
	 */
	@GetMapping(value="/person/produces", produces="application/company-name.app-name-v1+json")
	public PersonV1 producesV1()
	{
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value="/person/produces", produces="application/company-name.app-name-v2+json")
	public PersonV2 producesV2()
	{
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
