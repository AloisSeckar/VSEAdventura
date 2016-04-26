/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.IAuthorDemo;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGame;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.BasicActions;


import java.util.Collection;


/*******************************************************************************
 * {@code DemoApartmentGameG} instances are responsible for the game
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
public class DemoApartmentGame
     extends ANamed
    implements IGame, IAuthorDemo
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The crate keeping the mandatory action names. */
    private static final BasicActions BASIC_ACTIONS =
                     new BasicActions(Texts.aGOTO, Texts.aPUT_DOWN,
                                      Texts.aTAKE, Texts.aHELP, Texts.aEXIT);

    /** The only instance (singleton) of this game. */
    private static final DemoApartmentGame SINGLETON = new DemoApartmentGame();



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
     * The factory method returning the only instance of the given game.
     *
     * @return The instance of the given game
     */
    public static DemoApartmentGame getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * The private constructor defining the only instance of the game class.
     */
    private DemoApartmentGame()
    {
        super("Demo game: An apartment with an intelligent ice-box");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns information if the game is currently running.
     * The once started game cannot be started again.
     * If you want to start the game again you have to finish it firstly.
     *
     * @return If the game is running, it returns {@code true},
     *         otherwise it returns {@code false}
     */
    @Override
    public boolean isAlive()
    {
        return AAction.isAlive();
    }


    /***************************************************************************
     * Returns the bag to which the player will save the taken items.
     *
     * @return The bag to which the player saves the taken items
     */
    @Override
    public Hands getBag()
    {
        return Hands.getInstance();
    }


    /***************************************************************************
     * Returns the collection of all actions usable in the game.
     *
     * @return The collection of all actions usable in the game
     */
    @Override
    public Collection<AAction> getAllActions()
    {
        return AAction.getAllActions();
    }


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
    @Override
    public BasicActions getBasicActions()
    {
        return BASIC_ACTIONS;
    }


    /***************************************************************************
     * Returns the world in which the game takes place.
     *
     * @return The world in which the game takes place
     */
    @Override
    public Apartment getWorld()
    {
        return Apartment.getInstance();
    }


    /*@Override
    public URL getHelpURL()
    {
        //TODO DemoApartmentGameG.getHelpURL - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public Icon getMap()
    {
        //TODO DemoApartmentGameG.getMap - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public Icon getPlayer()
    {
        //TODO DemoApartmentGameG.getPlayer - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }*/



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Processes the given command and returns the answer to the user.
     * But it delegates the command processing itself to the action manager,
     * that is the class object {@link AAction}.
     *
     * @param command The entered command
     * @return The answer of the game after processing the command
     */
    @Override
    public String executeCommand(String command)
    {
        return AAction.executeCommand(command);
    }


    /*@Override
    public void addBagListener(IListener<IBagG> bagListener)
    {
        //TODO DemoApartmentGameG.addBagListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void addDialogListener(IListener<Boolean> dialogListener)
    {
        //TODO DemoApartmentGameG.addDialogListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void addItemListener(IListener<ISpaceG> objectListener)
    {
        //TODO DemoApartmentGameG.addItemListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void addNeighborsListener(IListener<ISpaceG> neighborsListener)
    {
        //TODO DemoApartmentGameG.addNeighborsListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void removeBagListener(IListener<IBagG> bagListener)
    {
        //TODO DemoApartmentGameG.removeBagListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void removeDialogListener(IListener<Boolean> dialogListener)
    {
        //TODO DemoApartmentGameG.removeDialogListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void removeItemListener(IListener<ISpaceG> objectListener)
    {
        //TODO DemoApartmentGameG.removeItemListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void removeNeighborsListener(IListener<ISpaceG> neighborsListener)
    {
        //TODO DemoApartmentGameG.removeNeighborsListener - Not supported yet
        throw new UnsupportedOperationException("Not supported yet.");
    }*/


    /***************************************************************************
     * Ends the whole game and returns the allocated resources.
     */
    @Override
    public void stop()
    {
        AAction.stopGame();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
