package traits

import pl.katas.NameInverter

trait NameInverterTrait {
    NameInverter nameInverter

    def setup() {
        nameInverter = new NameInverter()
    }
}