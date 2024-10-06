package bootleg_cli_pvz;

interface SunProducer {
    int produce_sun();
}

interface PlantUpgrade {
    int concurrentSunCost();
}

// add more interfaces here
interface Attacker {
    int attack();
    int rangeType();
}

interface InstantKiller{
    int killType();
}

interface Upgradable {
    PlantUpgrade upgrade();
}
