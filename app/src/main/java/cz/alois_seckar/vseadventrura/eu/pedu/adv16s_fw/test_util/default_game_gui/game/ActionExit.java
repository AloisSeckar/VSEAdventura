/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;



/*******************************************************************************
 * {@code ActionExit} instances process the commands
 * which require the prematured game termination.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionExit extends AAction
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
     * Creates the action instance for
     * prematured termination of the game.
     */
    ActionExit()
    {
        super (Texts.aEXIT,
               "It says thanks, good-bye and ends the game.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * The method ends the game and says thanks to the player.
     *
     * @param arguments Parameters of the command - not used here
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        AAction.stopGame();
        return Texts.mGOOD_BYE;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
