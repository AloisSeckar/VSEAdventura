/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;

import java.util.Collection;



/*******************************************************************************
 * Instances of the {@code IGame} interface are responsible for the game
 * logics. They are able to accept individual commands and provide information
 * on current state of the game and its parts.
 * <p>
 * The game class has to be defined as a singleton and,
 * besides methods declared in the {@link IGame} interface,
 * it has to define the {@code getInstance()} static factory method.
 * Fulfilling of this condition cannot be verified by the compiler, but they
 * can by verified by test utilizing the associated scenario manager.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IGame
         extends IGSMFactoryProduct, INamed
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns information if the game is currently running.
     * The once started game cannot be started again.
     * If you want to start the game again you have to finish it firstly.
     *
     * @return If the game is running, it returns {@code true},
     *         otherwise it returns {@code false}
     */
//    @Override
    public boolean isAlive()
    ;


    /***************************************************************************
     * Returns the bag to which the player will save the taken items.
     *
     * @return The bag to which the player saves the taken items
     */
//    @Override
    public IBag getBag()
    ;


    /***************************************************************************
     * Returns the collection of all actions usable in the game.
     *
     * @return The collection of all actions usable in the game
     */
//    @Override
    public Collection<? extends IAction> getAllActions()
    ;


    /***************************************************************************
     * Returns the crate with names of mandatory actions, i.e. actions for
     * <ul>
     *   <li>moving into neighboring space,</li>
     *   <li>taking item from the current space and putting it into bag,</li>
     *   <li>taking item from the bag and
     *       putting it down into the current space,</li>
     *   <li>asking for help,</li>
     *   <li>immediate game termination.</li>
     * </ul>
     *
     * @return The crate with names of mandatory actions
     */
//    @Override
    public BasicActions getBasicActions()
    ;


    /***************************************************************************
     * Returns the world in which the game takes place.
     *
     * @return The world in which the game takes place
     */
//    @Override
    public IWorld getWorld()
    ;



//== OTHER ABSTRACT METHODS ====================================================

    /***************************************************************************
     * Processes the given command and returns the answer to the user.
     *
     * @param command The entered command
     * @return The answer of the game after processing the command
     */
//    @Override
    public String executeCommand(String command)
    ;


    /***************************************************************************
     * Ends the whole game and returns the allocated resources.
     */
//    @Override
    public void stop()
    ;



//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
