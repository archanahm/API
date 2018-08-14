package com.kuoni.finance.automation.xml.test

import spock.lang.Specification

/**
 * Created by 104403 on 18/08/2014.
 */
class DemoTest extends Specification {

    def "Test that pass"() {
        given: "this is test"
        true
        when : "some codition"
        2 == 1 + 1
        then: "verify this"
        "great day".size() == 9
    }

    def "Test that fail"() {
        given : "this test will fail"
        true
        when : "fail condition"
        3 == 2+2
        then : "This is never executed"
        "fail".size() == 4
    }
}
