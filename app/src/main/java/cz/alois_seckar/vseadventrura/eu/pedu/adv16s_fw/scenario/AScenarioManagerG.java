/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IGSMFactoryG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IGameG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IScenarioManagerG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.DemoGSMFactory;

//import eu.pedu.adv14p_fw.test_util._Test_115;



/*******************************************************************************
 * Instance třídy {@code AScenarioManagerG} spravují scénáře své hry
 * předpokládající grafické uživatelské rozhraní.
 * Každá hra musí mít k dispozici minimálně
 * <b>základní úspěšný scénář</b>,
 * který demonstruje některou z možných cest úspěšného dokončení hry,
 * a <b>chybový scénář</b>,
 * který demonstruje reakci hry na chybně zadané příkazy.
 * <p>
 * Jednotlivé scénáře se musí lišit svým názvem,
 * přičemž názvy základního úspěšného a základního chybového scénáře
 * jsou předem pevně dány a není je možno změnit.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public abstract class AScenarioManagerG
              extends AScenarioManager
           implements IScenarioManagerG
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    /***************************************************************************
     * Vrátí instanci hry, kterou můžeme hrát podle spravovaných scénářů.
     * Metoda však nezaručuje stav hry, tj. jestli je např. právě rozehraná
     * a nebude ji proto třeba ji před dalším spuštěním nejprve ukončit.
     *
     * @return Instance hry hratelné podle spravovaných scénářů
     */
    public static final IGameG getDemoGameG()
    {
        Class<? extends IGSMFactoryG> factoryClass = DemoGSMFactory.class;
        IGSMFactoryG factory = IGSMFactoryG.getInstanceOfFactory(factoryClass);
        IGameG game = factory.getGame();
        return game;
    }



//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Vytvoří nového správce scénářů spravujícího všechny scénáře hry,
     * která je instancí třídy zadané svým class-objektem.
     * <p>
     * Správce, jehož je daná instance rodičovským podobjektem,
     * není po vytvoření tohoto rodiče ještě plně funkční - takovým se stane
     * až poté, co budou do jeho správy předány všechny požadované scénáře
     * a seznam spravovaných scénářů se zalepí.
     *
     * @param factoryClass  Class-objekt třídy, která je schopna zprostředkovat
     *                      instanci vytvářeného správce scénářů.
     */
    protected AScenarioManagerG(Class<? extends IGSMFactoryG> factoryClass)
    {
        super(factoryClass);
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//
//    /***************************************************************************
//     * Vrátí scénář určený pro test GUI.
//     *
//     * @return Scénář určený pro test GUI
//     */
//    public final Scenario getGuiTestScenario()
//    {
//        verifySealed();
//        return getScenario(GUI_TEST_SCENARIO_NAME);
//    }
//


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Test demonstrující hraní hry na implicitním GUI.
     */
    public void testGameG()
    {
//        _Test_115 test = _Test_115.getInstance(getDemoGameG());
//        test.playGameByScenario(HAPPY_SCENARIO_NAME);
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
