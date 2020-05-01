import spock.lang.Specification
import spock.lang.Unroll
import traits.NameInverterTrait

class NameInverterSpecification extends Specification implements NameInverterTrait {
    def "Should throw an exception when null provided"() {
        given:"I use Name inverter"
        when:"I try to invert null"
            nameInverter.invert(null)
        then:"I should get a NullPointerException"
            thrown(NullPointerException)
    }

    @Unroll
    def "Should return '#expectedInvertedValue' when '#valueToInvert' given"() {
        given:"I use Name inverter"
        when:"I try to invert '#valueToInvert'"
            def inverted = nameInverter.invert(valueToInvert)
        then:"I should get '#expectedInvertedValue'"
            inverted == expectedInvertedValue
        where:
            valueToInvert               || expectedInvertedValue
            ""                          || ""
            "  "                        || ""
            "Jan Kowalski"              || "Kowalski, Jan"
            "Pan Jan Kowalski"          || "Kowalski, Jan"
            "Pani Janina Kowalska"      || "Kowalska, Janina"
            "Pani Dr Janina Kowalska"   || "Kowalska, Janina, Dr"
            "mgr inż. Gracjan Kowalski" || "Kowalski, Gracjan, inż., mgr"
    }
}
