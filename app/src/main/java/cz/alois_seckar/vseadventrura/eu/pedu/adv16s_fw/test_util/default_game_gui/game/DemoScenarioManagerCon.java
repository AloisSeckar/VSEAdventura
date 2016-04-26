/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.AScenarioManagerG;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.ScenarioStep;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfScenario;



import org.joda.time.LocalDate;

import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfStep.*;
import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game.Texts.*;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.IAuthorDemo;



/*******************************************************************************
 * {@code DemoScenarioManagerLit} instances serves as
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
public class DemoScenarioManagerCon
     extends AScenarioManagerG
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
            mWELCOME_MSG//zFULL_WELCOMING
            ,
            HALL,
            new String[] { BEDROOM, LIVING_ROOM, BATHROOM },
            new String[] { SHOE_RACK, UMBRELLA },
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
        new ScenarioStep(tsMOVE, aGOTO + " " + BATHROOM,
            mMOVED + BATHROOM
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] {}
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + GLASSES,
            mTAKEN + GLASSES
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { GLASSES }
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + MAGAZINE,
            mTAKEN + MAGAZINE
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK },
            new String[] { GLASSES, MAGAZINE }
        )
        ,
        new ScenarioStep(tsMOVE, aGOTO + " " + HALL,
            mMOVED + HALL
            ,
            HALL,
            new String[] { BEDROOM, LIVING_ROOM, BATHROOM },
            new String[] { SHOE_RACK, UMBRELLA },
            new String[] { GLASSES, MAGAZINE }
        )
        ,
        new ScenarioStep(tsMOVE, aGOTO + " " + LIVING_ROOM,
            mMOVED + LIVING_ROOM
            ,
            LIVING_ROOM,
            new String[] { KITCHEN, HALL },
            new String[] { TV },
            new String[] { GLASSES, MAGAZINE }
        )
        ,
        new ScenarioStep(tsMOVE, aGOTO + " " + KITCHEN,
            mMOVED + KITCHEN
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, PAPER },
            new String[] { GLASSES, MAGAZINE }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, aOPEN + " " + ICE_BOX,
            mICEBOX_CANNOT_BE_OPENED
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, PAPER },
            new String[] { GLASSES, MAGAZINE }
        )
        ,
        new ScenarioStep(tsBAG_FULL, aTAKE + " " + PAPER,
            mBAG_FULL
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, PAPER },
            new String[] { GLASSES, MAGAZINE }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, aPUT_DOWN + " " + MAGAZINE,
            mPUT_DOWN + MAGAZINE
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, PAPER, MAGAZINE },
            new String[] { GLASSES }
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + PAPER,
            mTAKEN + PAPER
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, MAGAZINE },
            new String[] { GLASSES, PAPER }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, aREAD + " " + PAPER,
            mWANT_READ + PAPER
            + mNO_GLASS
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, MAGAZINE },
            new String[] { GLASSES, PAPER }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, aPUT_ON + " " + GLASSES,
            mGLASS_PUT_ON
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, MAGAZINE },
            new String[] { PAPER }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, aREAD + " " + PAPER,
            mWANT_READ + PAPER
            + mWRITTEN_ON_PAPER
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, MAGAZINE },
            new String[] { PAPER }
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + MAGAZINE,
            mTAKEN + MAGAZINE
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX },
            new String[] { PAPER, MAGAZINE }
        )
        ,
        new ScenarioStep(tsNON_STANDARD2, aUNDERLAY + " " + ICE_BOX + " " + MAGAZINE,
            mWANT_UNDERLAY + ICE_BOX + mWITH_ITEM + MAGAZINE + ".\n" +
            mNOT_CAPABLE
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX },
            new String[] { PAPER, MAGAZINE  }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, aPUT_DOWN + " " + PAPER,
            mPUT_DOWN + PAPER
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { PAPER, ICE_BOX },
            new String[] { MAGAZINE }
        )
        ,
        new ScenarioStep(tsNON_STANDARD2, aUNDERLAY + " " + ICE_BOX + " " + MAGAZINE,
            mWANT_UNDERLAY  + ICE_BOX + mWITH_ITEM + MAGAZINE + "." +
            mICEBOX_UNDERLAID
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { PAPER, ICE_BOX },
            new String[] {}
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, aOPEN + " " + ICE_BOX,
            mICEBOX_OPENED
            ,
            ICE_BOX,
            new String[] {},
            new String[] { BEER,  BEER,   BEER,
                           SALAMI, BUN, WINE, RUM },
            new String[] {}
        )
        ,
        new ScenarioStep(tsUNMOVABLE, aTAKE + " " + BEER,
            mTAKES_ALCOHOL + BEER + "."
            + mHOW_OLD
            ,
            ICE_BOX,
            new String[] {},
            new String[] { BEER,  BEER,   BEER,
                           SALAMI, BUN, WINE, RUM },
            new String[] {}
        )
        ,
        new ScenarioStep(tsDIALOG, ""+AGE,
            mBIRTH
            ,
            ICE_BOX,
            new String[] {},
            new String[] { BEER,  BEER,   BEER,
                           SALAMI, BUN, WINE, RUM },
            new String[] {}
        )
        ,
        new ScenarioStep(tsDIALOG, "" + BORN_YEAR,
            mBELIEVE
            + mTAKEN_FROM_IB + BEER
            + mDO_NOT_FORGET
            ,
            ICE_BOX,
            new String[] {},
            new String[] { BEER,  BEER,
                           SALAMI, BUN, WINE, RUM },
            new String[] { BEER }
        )
        ,
        new ScenarioStep(tsNON_STANDARD1, aCLOSE + " " + ICE_BOX,
            mICEBOX_CLOSED
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, PAPER },
            new String[] { BEER }
        )
        ,
        //===== The last happy scenario step =====
        new ScenarioStep(tsEND, aEXIT,
            mGOOD_BYE
            ,
            KITCHEN,
            new String[] { LIVING_ROOM, BEDROOM },
            new String[] { ICE_BOX, PAPER },
            new String[] { BEER }
        )

    };


    /** Step testing the incorrect game starting is defined separately,
     *  so that the indexes of the following steps could be simply set. */
    private static final ScenarioStep WRONG_START =
    new ScenarioStep(-1, tsNOT_START, "Start",
            mNOT_START
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
            mNO_CMD
            ,
            HALL,
            new String[] { BEDROOM, LIVING_ROOM, BATHROOM },
            new String[] { SHOE_RACK,  UMBRELLA },
            new String[] {}
        )
        ,
        new ScenarioStep(tsEMPTY, "",
            mEMPTY_CMD
            ,
            HALL,
            new String[] { BEDROOM, LIVING_ROOM, BATHROOM },
            new String[] { SHOE_RACK,  UMBRELLA },
            new String[] {}
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + UMBRELLA,
            mTAKEN + UMBRELLA
            ,
            HALL,
            new String[] { BEDROOM, LIVING_ROOM, BATHROOM },
            new String[] { SHOE_RACK },
            new String[] { UMBRELLA }
        )
        ,
        new ScenarioStep(tsMOVE, aGOTO + " " + BATHROOM,
            mMOVED + BATHROOM
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] { UMBRELLA }
        )
        ,
        new ScenarioStep(tsBAD_NEIGHBOR, aGOTO + " " + "xxx",
            mNOT_NEIGHBOR + "xxx"
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] { UMBRELLA }
        )
        ,
        new ScenarioStep(tsBAD_ITEM, aTAKE + " " + BATHROOM,
            mNOT_HERE + BATHROOM
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] { UMBRELLA }
        )
        ,
        new ScenarioStep(tsUNMOVABLE, aTAKE + " " + SINK,
            mHEAVY_ITEM + SINK
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] { UMBRELLA }
        )
        ,
        new ScenarioStep(tsNOT_IN_BAG, aPUT_DOWN + " " + PAPER,
            mNOT_IN_BAG + PAPER
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] { UMBRELLA }
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + GLASSES,
            mTAKEN + GLASSES
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
        )
        ,
        new ScenarioStep(tsBAG_FULL, aTAKE + " " + MAGAZINE,
            mBAG_FULL
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
        )
        ,
        new ScenarioStep(tsMOVE_WA, aGOTO,
            mNO_TARGET
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
        )
        ,
        new ScenarioStep(tsTAKE_WA, aTAKE,
            mNO_TAKE_ITEM
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
        )
        ,
        new ScenarioStep(tsPUT_DOWN_WA, aPUT_DOWN,
            mNO_PUT_ITEM
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
        )
        ,
        new ScenarioStep(tsHELP, aHELP,
            mHELP
            //Text continues with the list of actions and their descriptions
            //and ends with the standard description of current situation
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
        )
        ,
        //===== The last mistake scenario step =====
        new ScenarioStep(tsEND, aEXIT,
            mGOOD_BYE
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { UMBRELLA, GLASSES }
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
        new ScenarioStep(tsHELP, aHELP,
            mHELP
            //Text continues with the list of actions and their descriptions
            //and ends with the standard description of current situation
            ,
            HALL,
            new String[] { BEDROOM, LIVING_ROOM, BATHROOM },
            new String[] { SHOE_RACK, UMBRELLA },
            new String[] {}
        )
        ,
        new ScenarioStep(tsMOVE, aGOTO + " " + BATHROOM,
            mMOVED + BATHROOM
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] {}
        )
        ,
        new ScenarioStep(tsTAKE, aTAKE + " " + GLASSES,
            mTAKEN + GLASSES
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { SINK, MAGAZINE },
            new String[] { GLASSES }
        )
        ,
        new ScenarioStep(tsPUT_DOWN, aPUT_DOWN + " " + GLASSES,
            mPUT_DOWN + GLASSES
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] {}
        )
        ,
        new ScenarioStep(tsEND, aEXIT,
            mGOOD_BYE
            ,
            BATHROOM,
            new String[] { HALL },
            new String[] { GLASSES, SINK, MAGAZINE },
            new String[] {}
        )
        ,
    };


    /** The only instance of this class.
     *  It manages all scenarios of the associated game. */
    private static final DemoScenarioManagerCon MANAGER =
                                          new DemoScenarioManagerCon();



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
    public static DemoScenarioManagerCon getInstance()
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
    private DemoScenarioManagerCon()
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
