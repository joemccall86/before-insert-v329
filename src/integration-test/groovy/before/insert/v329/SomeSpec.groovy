package before.insert.v329


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class SomeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given: 'a new person'
        def person = new Person(name: 'John', occupation: 'Grails developer').save()

        when: 'the name is changed'
        person.name = 'Dave'

        then: 'the name field is dirty'
        person.dirtyPropertyNames.contains 'name'
        person.isDirty('name')
    }
}
