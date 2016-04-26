/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.empty_classes;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.BasicActions;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IAction;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IBag;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGame;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IWorld;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.UncompletedMethodException;

import java.util.Collection;



/*******************************************************************************
 * Instances of the {@code EmptyGame} class are responsible for the game
 * logics. They are able to accept individual commands and provide information
 * on current state of the game and its parts.
 * <p>
 * The game class has to be defined as a singleton and,
 * besides methods declared in the {@link IGame} interface,
 * it has to define the {@code getInstance()} static factory method.
 * Fulfilling of this condition cannot be verified by the compiler, but they
 * can by verified by test utilizing the associated scenario manager.
 * <p>
 * {@code EmptyGame} instances represent prototypes of game instances
 * which are not yet fully defined and serve only for completion
 * of the scenario managers features, which needs cooperation with the game.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class EmptyGame extends ANamed implements IGame, IAuthorPrototype
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The reference to the only instance (singleton) of this game. */
    private static final EmptyGame SINGLETON = new EmptyGame();



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
    public static EmptyGame getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * The private constructor defining the only instance of the game class.
     * Because it is private, it has to be defined despite its body is empty.
     */
    private EmptyGame()
    {
        super("Game name with very short description");
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
        //TODO EmptyGame.isAlive - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the bag to which the player will save the taken items.
     *
     * @return The bag to which the player saves the taken items
     */
    @Override
    public IBag getBag()
    {
        //TODO EmptyGame.getBag - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the collection of all actions usable in the game.
     *
     * @return The collection of all actions usable in the game
     */
    @Override
    public Collection<? extends IAction> getAllActions()
    {
        //TODO EmptyGame.getAllActions - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the crate with names of mandatory actions, i.e. actions for
     * <ul>
     *   <li>moving into another space,</li>
     *   <li>taking item from the space and putting it into the bag,</li>
     *   <li>taking item from the bag and putting it down
     *       in the current space,</li>
     *   <li>asking for help,</li>
     *   <li>immediate game termination.</li>
     * </ul>
     *
     * @return The crate with names of mandatory actions
     */
    @Override
    public BasicActions getBasicActions()
    {
        //TODO EmptyGame.getBasicActions - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the world in which the game takes place.
     *
     * @return The world in which the game takes place
     */
    @Override
    public IWorld getWorld()
    {
        //TODO EmptyGame.getWorld - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Processes the given command and returns the answer to the user.
     *
     * @param command The entered command
     * @return The answer of the game after processing the command
     */
    @Override
    public String executeCommand(String command)
    {
        //TODO EmptyGame.executeCommand(String) - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Ends the whole game and returns the allocated resources.
     */
    @Override
    public void stop()
    {
        //TODO EmptyGame.stop - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
