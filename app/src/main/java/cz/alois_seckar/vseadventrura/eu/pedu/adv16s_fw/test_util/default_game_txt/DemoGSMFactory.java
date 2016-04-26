/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game.DemoApartmentGame;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game.DemoScenarioManagerCon;
//import DemoScenarioManagerLit;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IUI;



/*******************************************************************************
 * {@code DemoGSMFactory } instances represent the factory objects
 * which are able to deliver the game instance,
 * an instance of scenario manager of this game
 * and an instance of the text user interface.
 * As long as some of these objects are not yet fully defined,
 * the methods throw the
 * {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.UncompletedMethodException}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class DemoGSMFactory implements IGSMFactory, IAuthorDemo
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Creates the factory object providing the key application objects.
     */
    public DemoGSMFactory()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the instance of the scenario manager.
     *
     * @return Required scenario manager
     */
    @Override
    public DemoScenarioManagerCon getScenarioManager()
    {
        return DemoScenarioManagerCon.getInstance();
    }

//
//    /***************************************************************************
//     * Returns the instance of the scenario manager.
//     *
//     * @return Required scenario manager
//     */
//    @Override
//    public DemoScenarioManagerLit getScenarioManager()
//    {
//        return DemoScenarioManagerLit.getInstance();
//    }
//

    /***************************************************************************
     * Returns the instance of text version of the game.
     *
     * @return Required game
     */
    @Override
    public DemoApartmentGame getGame()
    {
        return DemoApartmentGame.getInstance();
    }


    /***************************************************************************
     * Returns the object executing the user interface.
     *
     * @return Required user interface
     */
    @Override
    public IUI getUI()
    {
        IUI ui = null;
//                 new UIA_JOptionPane();
//                 new UIB_Console();
//                 new UIC_GamePlayer(new UIC_GamePlayer.ByJOptionPane());
//                 new UIC_GamePlayer(new UIC_GamePlayer.ByScanner());
//                 new UID_Multiplayer(new UID_Multiplayer.ByJOptionPane());
//                 new UID_Multiplayer(new UID_Multiplayer.ByScanner());
        return ui;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
