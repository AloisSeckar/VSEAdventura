/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.IAuthorDemo;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.AScenarioManager;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.ScenarioStep;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfScenario;



import org.joda.time.LocalDate;

import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfStep.*;


/*******************************************************************************
 * {@code DemoScenarioManagerLit} instance serves as
 * scenario manager, that has to manage the scenarios of the associated game.
 * These scenarios should allow to test and demonstrate
 * the functionality of the associated game.
 * In this class the texts are defined as literals.
 * <p>
 * Each manager has to offer:
 * <ul>
 *   <li>The <b>happy scenario</b> (the basic successful one)
 *     demonstrating certain successful path through the game possibilities
 *     leading to the game goal.
 *   </li>
 *   <li>The <b>mistake scenario</b>
 *     demonstrating the game reaction to the wrongly entered commands.
 *   </li>
 * </ul>
 * <p>
 * Individual managed scenarios have to differ by their names;
 * the names of the happy scenario and the mistake one
 * are firmly pre-determined and cannot be arbitrarily set.
 * <p>
 * Individual scenarios are iterable and "streamable" sequences of steps
 * specified by instances of the framework class
 * {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.ScenarioStep},
 * to which the designed game should be associated.
 * <p>
 * Scenario manager is a singleton, that is responsible
 * for all scenarios concerning the game associated with it.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class DemoScenarioManagerLit
     extends AScenarioManager
  implements IAuthorDemo
{
//== CONSTANT CLASS FIELDS =====================================================

    /** Name of the scenario with steps for testing mandatory actions. */
    private static final String REQUIRED_STEPS_SCENARIO_NAME = "REQUIRED";

    /** Auxiliary constants for conversation with the ice-box. */
    private static final int AGE = 20;
    private static final int THIS_YEAR;
    private static final int BORN_YEAR;
    static {
        THIS_YEAR = LocalDate.now().getYear();
        BORN_YEAR = THIS_YEAR - AGE;
    }


    /***************************************************************************
     * The starting step identical for all scenarios.
     * <p>
     * Constructor of the full-fledged {@link ScenarioStep} class instance
     * requires the following parameters:
     <pre> {@code
TypeOfStep typeOfStep; //Type of the given scenario step
String     command;    //Command realizing this scenario step
String     message;    //Message written after entering the command
String     space;      //Current space after entering the command
String[]   neighbors;  //Neighbors of the current space (= exits)
String[]   items;      //Items occuring in the current space
String[]   bag;        //Current bag content
     }</pre>
     =======================================================================<br>
     * Scenario steps have to comply with the following requirements:
     * <ul>
     *   <li>None of the items may contain the {@code null} value.</li>
     *   <li>With the exception of {@code command} no string may be
     *     empty (i.e. {@code ""})</li>
     *   <li>Empty string may occur neither as an item in the array
     *     {@code neighbors}, nor {@code items} nor {@code bag}</li>
     * </ul>
     * <br>
     ***************************************************************************
     */
    private static final ScenarioStep START_STEP =
        new ScenarioStep(0, tsSTART,  "", //Starting command
            "Welcome in the official apartment. You are surely hungry.\n"
          + "Find the ice-box - refreshment is waiting you there."
            ,
            "Hall",
            new String[] { "Bedroom", "Living-room", "Bathroom" },
            new String[] { "Shoe-rack", "Umbrella" },
            new String[] {}
        );


    /***************************************************************************
     * Steps of the happy scenario
     * describing the expectable successful game running. It is not necessary
     * for the scenario compiled of these steps to be the shortest possible
     * (it implies, that it has not to be the true basic successful scenario),
     * but it has to comply with all marginal conditions of the assignment,
     * i.e. it has to contain minimal number of steps,
     * pass through the required minimal number of spaces
     * and demonstrate using of all required actions.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP
        ,
        new ScenarioStep(tsMOVE, "goto bathroom",
            "You have moved to a room: Bathroom"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsTAKE, "take glasses",
            "You have taken an item: Glasses"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Glasses" }
        )
        ,
        new ScenarioStep(tsTAKE, "take magazine",
            "You have taken an item: Magazine"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink" },
            new String[] { "Glasses", "Magazine" }
        )
        ,
        new ScenarioStep(tsMOVE, "goto hall",
            "You have moved to a room: Hall"
            ,
            "Hall",
            new String[] { "Bedroom", "Living-room", "Bathroom" },
            new String[] { "Shoe-rack", "Umbrella" },
            new String[] { "Glasses", "Magazine" }
        )
        ,
        new ScenarioStep(tsMOVE, "goto living-room",
            "You have moved to a room: Living-room"
            ,
            "Living-room",
            new String[] { "Kitchen", "Hall" },
            new String[] { "TV" },
            new String[] { "Glasses", "Magazine" }
        )
        ,
        new ScenarioStep(tsMOVE, "goto kitchen",
            "You have moved to a room: Kitchen"
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] { "Glasses", "Magazine" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, "open ice-box",
            "The entered action has not been carried out.\n"
          + "Ice-box cannot be open. Paper with writing lies on it."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] { "Glasses", "Magazine" }
        )
        ,
        new ScenarioStep(tsBAG_FULL, "take paper",
            "The entered action has not been carried out.\n"
          + "You cannot take the entered item, "
          + "both your hands are already full."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] { "Glasses", "Magazine" }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, "put_down magazine",
            "You have put down an item: Magazine"
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper", "Magazine" },
            new String[] { "Glasses" }
        )
        ,
        new ScenarioStep(tsTAKE, "take paper",
            "You have taken an item: Paper"
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Magazine" },
            new String[] { "Glasses", "Paper" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, "read paper",
            "You have decided to read the paper.\n"
          + "However, text is written with too small letters that are blurry.\n"
          + "You have to take on glasses."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Magazine" },
            new String[] { "Glasses", "Paper" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, "put_on glasses",
            "You have put glasses on."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Magazine" },
            new String[] { "Paper" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, "read paper",
            "You have decided to read the paper.\n"
          + "It is written at the paper:\n"
          + "Ice-box stands askew and therefore it opens with difficulty.\n"
          + "In case of problems, underlay it with something."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Magazine" },
            new String[] { "Paper" }
        )
        ,
        new ScenarioStep(tsTAKE, "take magazine",
            "You have taken an item: Magazine"
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box" },
            new String[] { "Magazine", "Paper" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD2, "underlay ice-box magazine",
            "You have decided to underlay ice-box with magazine.\n"
          + "The entered action has not been carried out.\n"
          + "Unfortunately your both hands are full\n"
          + "and thus you have no empty hand for execution."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box" },
            new String[] { "Magazine", "Paper" }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, "put_down paper",
            "You have put down an item: Paper"
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] { "Magazine" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD2, "underlay ice-box magazine",
            "You have decided to underlay ice-box with magazine.\n"
          + "Ice-box is successfully underlaid - now it could be open."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, "open ice-box",
            "You have successfully opened the ice-box."
            ,
            "Ice-box",
            new String[] {},
            new String[] { "Beer",  "Beer",   "Beer",
                           "Salami", "Bun", "Wine", "Rum" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsUNMOVABLE, "take beer",
            "You try to take Beer.\n"
          + "This is an intelligent ice-box which does not enable\n"
          + "serving of alcoholic drinks to under-aged.\n"
          + "How old are you?"
            ,
            "Ice-box",
            new String[] {},
            new String[] { "Beer", "Beer", "Beer",
                           "Salami", "Bun", "Wine", "Rum" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsDIALOG, "" + AGE,
            "What is your year of birth?"
            ,
            "Ice-box",
            new String[] {},
            new String[] { "Beer", "Beer", "Beer",
                           "Salami", "Bun", "Wine", "Rum" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsDIALOG, "" + BORN_YEAR,
            "I believe you and pass you the required drink.\n"
          + "You have taken from ice-box: Beer\n"
          + "Bon appetit. Do not forget to close the ice-box."
            ,
            "Ice-box",
            new String[] {},
            new String[] { "Beer", "Beer",
                           "Salami", "Bun", "Wine", "Rum" },
            new String[] { "Beer" }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, "close ice-box",
            "You have successfully closed the ice-box."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] { "Beer" }
        )
        ,
        //===== The last happy scenario step =====
        new ScenarioStep(tsEND, "end",
            "Game end.\n"
          + "Thank you that you have tried our game."
            ,
            "Kitchen",
            new String[] { "Living-room", "Bedroom" },
            new String[] { "Ice-box", "Paper" },
            new String[] { "Beer" }
        )

    };


    /** Step testing the incorrect game starting is defined separately,
     *  so that the indexes of the following steps could be simply set. */
    private static final ScenarioStep WRONG_START =
    new ScenarioStep(-1,
            tsNOT_START, "Start",
            "The first command is not the starting one.\n"
          + "Not running game can be started only by the starting command."
            ,
            "",
            new String[] {},
            new String[] {},
            new String[] {}
        );


    static { ScenarioStep.setIndex(1); }


    /***************************************************************************
     * Mistake scenario defining reactions
     * to mandatory set of types of incorrectly entered commands.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        WRONG_START
        ,
        START_STEP
        ,
        new ScenarioStep(tsUNKNOWN, "xxx",
            "The entered action has not been carried out.\n"
          + "I do not know this command.\n"
          + "If you need a help, enter a command ?"
            ,
            "Hall",
            new String[] { "Bedroom", "Living-room", "Bathroom" },
            new String[] { "Shoe-rack", "Umbrella" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsEMPTY, "",
            "You have entered an empty command.\n"
          + "It can be used only for starting the game.\n"
          + "If you need a help, enter a command ?"
            ,
            "Hall",
            new String[] { "Bedroom", "Living-room", "Bathroom" },
            new String[] { "Shoe-rack",  "Umbrella" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsTAKE, "take umbrella",
            "You have taken an item: Umbrella"
            ,
            "Hall",
            new String[] { "Bedroom", "Living-room", "Bathroom" },
            new String[] { "Shoe-rack" },
            new String[] { "Umbrella" }
        )
        ,
        new ScenarioStep(tsMOVE, "goto bathroom",
            "You have moved to a room: Bathroom"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] { "Umbrella" }
        )
        ,
        new ScenarioStep(tsBAD_NEIGHBOR, "goto toilet",
            "The entered action has not been carried out.\n"
          + "The destination room is not a neighbor of the current room: toilet"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] { "Umbrella" }
        )
        ,
        new ScenarioStep(tsBAD_ITEM, "take bathroom",
            "The entered action has not been carried out.\n"
          + "The entered item is not in the room: Bathroom"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] { "Umbrella" }
        )
        ,
        new ScenarioStep(tsUNMOVABLE, "take sink",
            "The entered action has not been carried out.\n"
          + "The entered item cannot be taken: Sink"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] { "Umbrella" }
        )
        ,
        new ScenarioStep(tsNOT_IN_BAG, "put_down paper",
            "The entered action has not been carried out.\n"
          + "The item is not in the bag: Paper"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] { "Umbrella" }
        )
        ,
        new ScenarioStep(tsTAKE, "take glasses",
            "You have taken an item: Glasses"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
        new ScenarioStep(tsBAG_FULL, "take magazine",
            "The entered action has not been carried out.\n"
          + "You cannot take the entered item, "
          + "both your hands are already full."
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
        new ScenarioStep(tsMOVE_WA, "goto",
            "The entered action has not been carried out.\n"
          + "You did not enter where to go"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
        new ScenarioStep(tsTAKE_WA, "take",
            "The entered action has not been carried out.\n"
          + "You did not enter what should be taken"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
        new ScenarioStep(tsPUT_DOWN_WA, "put_down",
            "The entered action has not been carried out.\n"
          + "You did not enter what should be put down"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
        new ScenarioStep(tsHELP, "?",
              "Commands that can be entered during the game course:\n"
            + "===================================================="
            //Text continues with listing the commands and their descriptions
            //and ends by a standard description of current situation
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
        //===== The last mistake scenario step =====
        new ScenarioStep(tsEND, "end",
            "Game end. \nThank you that you have tried our game."
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Umbrella", "Glasses" }
        )
        ,
    };


    static { ScenarioStep.setIndex(1); }


    /***************************************************************************
     * Scenario steps determined for verification of mandatory actions,
     * precisely actions for moving to a space, taking and putting an item,
     * writing the help and prematured game termination.
     */
    private static final ScenarioStep[] REQUIRED_STEPS =
    {
        START_STEP
        ,
        new ScenarioStep(tsHELP, "?",
            "\nCommands that can be entered during the game:\n"
            + "============================================"
            //Text continues with listing the actions and their descriptions
            //and ends by a standard description of current situation
            ,
            "Hall",
            new String[] { "Bedroom", "Living-room", "Bathroom" },
            new String[] { "Shoe-rack", "Umbrella" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsMOVE, "goto bathroom",
            "You have moved to a room: Bathroom"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsTAKE, "take glasses",
            "You have take on an item: Glasses"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Sink", "Magazine" },
            new String[] { "Glasses" }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, "put_down glasses",
            "You have putdown an item: Glasses"
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] {}
        )
        ,
        new ScenarioStep(tsEND, "end",
            "Game end.\nThank you that you have tried our game."
            ,
            "Bathroom",
            new String[] { "Hall" },
            new String[] { "Glasses", "Sink", "Magazine" },
            new String[] {}
        )
        ,
    };


    /** The only instance of this class.
     *  It manages all scenarios of the associated game. */
    private static final DemoScenarioManagerLit MANAGER =
                                          new DemoScenarioManagerLit();



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /***************************************************************************
     * Static constructor is placed before definitions of constants
     * {@link #AGE}, {@link #THIS_YEAR} and {@link #BORN_YEAR}
     * and once again before the definition of a constant
     * {@link MISTAKE_SCENARIO_STEPS}.
     * Such initialization should be before each further constant
     * defining the steps of the following scenario.
     */



//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Returns scenario manager - the only instance of this class.
     *
     * @return Scenario manager
     */
    public static DemoScenarioManagerLit getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Creates an instance representing the game scenario manager.
     * Within the constructor framework it is suitable to create all scenarios
     * and seal the scenario manager after it.
     * <p>
     * Individual managed scenarios have to differ by their names,
     * the names of the happy scenario and the mistake one
     * are firmly pre-determined and cannot be changed.
     * Names given to them in the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * are therefore only formal, because the called method assigns to them
     * the names defined in advance in appropriate constants.
     * <p>
     * Contract of the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * requires so that the happy scenario, i.e. scenario of the
     * {@link //TypeOfScenario.scHAPPY}) type, would be added as the first one,
     * and the mistake scenario, i.e. the scenario of the
     * {@link //MISTAKE_SCENARIO_NAME} type, as the second one.
     * The order of the subsequently added scenarios is not decisive.
     */
    private DemoScenarioManagerLit()
    {
        super(FACTORY_CLASS);

        addScenario(HAPPY_SCENARIO_NAME,
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario(MISTAKE_SCENARIO_NAME,
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        addScenario(REQUIRED_STEPS_SCENARIO_NAME,
                    TypeOfScenario.scGENERAL,  REQUIRED_STEPS);
        seal();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================



//##############################################################################
//== TEST METHODS AND CLASSES ==================================================

    /***************************************************************************
     * Method verifying the given scenario manager and the associated game
     * by scenarios of this manager.
     * <p>
     * The scenario manager is verified if it complies
     * with the following conditions:
     * <ul>
     *   <li>It knows to return properly formated name of the game author
     *       and his/her ID.</li>
     *   <li>It defines the happy scenario and the mistake one.</li>
     *   <li>The mistake scenario has the following properties:
     *     <ul>
     *       <li>Starting command, the name of which is an empty string</li>
     *       <li>Minimal required number of steps</li>
     *       <li>Minimal number of visited spaces</li>
     *       <li>Minimal number of "glimpsed" spaces</li>
     *       <li>Minimal number of own (optional) actions</li>
     *       <li>Usage of actions for moving from the current space
     *         to a neighboring space, taking item and putting down item</li>
     *       <li>Cross consistence of actions and states after execution
     *         of the actions</li>
     *     </ul>
     *   </li>
     *   <li>The mistake scenario has the following properties:
     *     <ul>
     *       <li>Incorrect starting by a not empty command,</li>
     *       <li>Starting command the name of which is an empty string</li>
     *       <li>Usage of all mandatory error step types defined in the<br>
     *         {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfStep} enum type</li>
     *       <li>Asking for a help</li>
     *       <li>Premature game termination</li>
     *     </ul>
     *   </li>
     * </ul>
     * <p>
     * The game is verified if it can be played exactly
     * as is planned in scenarios.
     *
     * @param args Command line parameters - unused.
     */
    public static void main(String[] args)
    {
        //Tests if the scenario manager and its scenarios
        //comply with requirements
//        MANAGER.autoTest();

        //Simulates playing the game according to happy scenario
//        MANAGER.getHappyScenario().simulate();

        //Game testing according to scenarios with the given names
//        MANAGER.testGameByScenarios(MISTAKE_SCENARIO_NAME);

        //Game testing made gradually according to both mandatory scenarios,
        //the happy scenario is passed twice one after the other
        MANAGER.testGame();

        //Playing the game according to the scenario with the given name
//        MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
