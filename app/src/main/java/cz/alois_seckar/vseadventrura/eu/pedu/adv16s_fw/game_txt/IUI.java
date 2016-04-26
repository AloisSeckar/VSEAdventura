/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;



/*******************************************************************************
 * Interface {@code IUI} declares the requirements to the class
 * defining the game user interface.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IUI
         extends IGSMFactoryProduct
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the currently played game.
     *
     * @return The currently played game
     */
//    @Override
    public IGame getGame()
    ;



//== OTHER ABSTRACT METHODS ====================================================

    /***************************************************************************
     * Starts the the given game
     * and runs the communication between this game and the user.
     *
     * @param game The game, which should be run
     */
//    @Override
    public void startGame(IGame game)
    ;



//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================

    /***************************************************************************
     * Starts the default game, which means the game returned by the instance
     * of this GUI's factory class,
     * and runs the communication between this game and the user.
     */
//    @Override
    default void startGame()
    {
        Class <? extends IGSMFactory> fatoryClass = getFactoryClass();
        IGSMFactory factory = IGSMFactory.getInstanceOfFactory(fatoryClass);
        IGame       game    = factory.getGame();
        startGame(game);
    }



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
