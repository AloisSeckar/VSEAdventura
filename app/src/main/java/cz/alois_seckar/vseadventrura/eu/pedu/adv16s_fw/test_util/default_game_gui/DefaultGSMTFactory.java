/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGSMFactory;


/*******************************************************************************
 * Instance třídy {@code DefaultGSMTFactory} představují tovární objekty,
 * které jsou schopny na požádání dodat instanci hry,
 * instanci správce scénářů této hry
 * a instanci textového uživatelského rozhraní.
 * Dokud ještě některé z těchto objektů nejsou definovány,
 * vyhazují metody výjimku
 * {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.UncompletedMethodException}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class DefaultGSMTFactory implements IGSMFactory, IAuthorDemo
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
     * Vytvoří tovární objekt poskytující klíčové objekty aplikace.
     */
    public DefaultGSMTFactory()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí odkaz na instanci správce scénářů.
     *
     * @return Požadovaný odkaz
     */
//    @Override
//    public AScenarioManager getScenarioManager()
//    {
//        return DemoScenarioManagerCon.getInstance();
////        return DemoScenarioManagerLit.getInstance();
//    }


    /***************************************************************************
     * Vrátí odkaz na instanci textové verze hry.
     *
     * @return Požadovaný odkaz
     */
//    @Override
//    public DemoAppartmentGame getGame()
//    {
//        return DemoAppartmentGame.getInstance();
//    }


    /***************************************************************************
     * Vrátí odkaz na instanci třídy realizující uživatelské rozhraní.
     *
     * @return Požadovaný odkaz
     */
//    @Override
//    public IUI getUI()
//    {
//        return TextUI_Instance;
//    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
