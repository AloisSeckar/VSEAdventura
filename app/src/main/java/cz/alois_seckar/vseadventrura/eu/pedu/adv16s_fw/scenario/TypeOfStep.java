/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;



/*******************************************************************************
 * Instances of the {@code TypeOfStep} enum type represent
 * the possible types of scenario steps.
 * The knowledge of these types allows to check the correctness
 * of data specified for particular steps.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public enum TypeOfStep
{
//== VALUES OF THE ENUMERATION TYPE ============================================

    /** The type of step, which is not determined for insertion into certain
     *  scenario, but for supplement of the error message and for auxiliary
     *  actions. */                               tsNOT_SET  (6,-1, null),

//Type of steps that have to be in the happy scenario. */
    /** Start step with the empty name.         */tsSTART    (0,-1, null),
    /** The player moves into neighboring space.*/tsMOVE     (0, 1, null),
    /** Successful taking of item from space.   */tsTAKE     (0, 1, null),
    /** Successful putting down of item in bag. */tsPUT_DOWN (0, 1, null),

//The following types of steps may not crash the game, i.e. the game should
//correctly react to them => they have to be tested in the mistake scenario

    /** Immediate finishing the game.           */tsEND      (1, 0, null),
    /** Help.                                   */tsHELP     (1, 0, null),

//Problems with correct command entering
    /** Starting command is not empty string.   */tsNOT_START(2,-1, null),
    /** Empty string not starting the game.     */tsEMPTY    (2,-1, tsSTART),
    /** Unknown action.                         */tsUNKNOWN  (2,-1, null),

//Calling some of the basic one-parametric action without the argument
    /** I do not know where to move.     */tsMOVE_WA         (2, 0, tsMOVE),
    /** I do not know what to take.      */tsTAKE_WA         (2, 0, tsTAKE),
    /** I do not know what to put down.  */tsPUT_DOWN_WA     (2, 0, tsPUT_DOWN),

//Problems with changing the space
    /** The target space is not a neighbor.  */tsBAD_NEIGHBOR(2, 1, tsMOVE),

//Problems with taking and putting down the item
    /** The item is not in the current space.*/tsBAD_ITEM    (2, 1, tsTAKE),
    /** The item is not takeable.            */tsUNMOVABLE   (2, 1, tsTAKE),
    /** The item cannot fit into the bag.    */tsBAG_FULL    (2, 1, tsTAKE),
    /** The item is not in the bag.          */tsNOT_IN_BAG  (2, 1, tsPUT_DOWN),

//Non-mandatory types of steps
    /** Nullary (parameter-less) action not belonging to the mandatory ones;
     *  it only changes certain internal state.  */tsNON_STANDARD0(3, 0, null),

    /** Unary (one-parametric) action not belonging to the mandatory ones;
     *  it only changes certain internal state.  */tsNON_STANDARD1(3, 1, null),

    /** Binary (two-parametric) action not belonging to the mandatory ones;
     *  it only changes certain internal state.  */tsNON_STANDARD2(3, 2, null),

    /** Ternary (three-parametric) action not belonging to the mandatory ones;
     *  it only changes certain internal state.  */tsNON_STANDARD3(3, 3, null),

    /** The state does not describe an action, it is a part of a dialogue
     *  or some similar action.                  */tsDIALOG       (4,-1, null),

//Type of steps not usable for testing the reaction to the command
    /** Steps of this type are meant for game demonstration and therefore
     *  it does not contain any information about the game state and thus
     *  it cannot be used as the testing one.    */tsDEMO         (5,-1, null),
     ;



//##############################################################################
//== CONSTANT CLASS FIELDS =====================================================

    /** Basic types of the mandatory actions. */
    public static final Set<TypeOfStep> BASIC_ACTIONS;

    /** Step types, which have to be incorporated into happy scenario. */
    public static final Set<TypeOfStep> REGULAR_ACTIONS;

    /** Step types, which have to be incorporated into mistake scenario.
     *  The help + immediate end belong here, various types of the
     * incorrectly entered commands that may not crash the game.
     * The game should correctly react to all these type of steps
     * and the mistake scenario tests it. */
    public static final Set<TypeOfStep> MISTAKE_ACTIONS;



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    static {
        Set<TypeOfStep> basic   = EnumSet.noneOf(TypeOfStep.class);
        Set<TypeOfStep> regular = EnumSet.noneOf(TypeOfStep.class);
        Set<TypeOfStep> mistake = EnumSet.noneOf(TypeOfStep.class);
        for (TypeOfStep stepType : TypeOfStep.values()) {
            if (null != stepType.SUBTYPE) {
                switch (stepType.SUBTYPE)
                {
                    case stCORRECT:
                        basic  .add(stepType);
                        regular.add(stepType);
                        break;
                    case stHELPSTOP:
                        basic  .add(stepType);
                        mistake.add(stepType);
                        break;
                    case stMISTAKE:
                        mistake.add(stepType);
                        break;
                    default:
                        break;
                }
            }
        }
        //Define all sets as immutable
        REGULAR_ACTIONS = Collections.unmodifiableSet(regular);
        MISTAKE_ACTIONS = Collections.unmodifiableSet(mistake);
        BASIC_ACTIONS   = Collections.unmodifiableSet(basic);
    }



//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================

    /** Subtype of this type of step. */
    public final Subtype SUBTYPE;

    /** Required number of arguments (parameters). */
    public final int PARAM_COUNT;

    /** The group of types, which activate the same action. */
    public final TypeOfStep GROUP;


//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Defines the new type of step according to the argument values
     * it assigns the subtype and the required type of parameters.
     *
     * @param subtype    Subtype ordinal number (to have the code shorter)
     * @param paramCount Required number of parameters/arguments. <br>
     *                   The value {@code -1} is used with types of commands,
     *                   where it is not usable to study this number.
     * @param group      The leader of the group of equivalent types
     */
    private TypeOfStep(int subtype, int paramCount, TypeOfStep group)
    {
        this.SUBTYPE     = Subtype.values()[subtype];
        this.PARAM_COUNT = paramCount;
        this.GROUP       = (group == null)  ?  this  :  group;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the subtype of this type.
     *
     * @return Subtype of this type
     */
    public Subtype getSubtype()
    {
        return SUBTYPE;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================

    /***************************************************************************
     * The scenario step types are selected into several subtypes.
     * This nested enum type defines them.
     */
    public enum Subtype
    {
        /** Correctly entered mandatory command from HAPPY.  0 */ stCORRECT,
        /** Correctly entered HELP or STOP.                  1 */ stHELPSTOP,
        /** Compulsorily tested wrong command.               2 */ stMISTAKE,
        /** Facultative action.                              3 */ stNONSTANDARD,
        /** Part of the dialogue.                            4 */ stDIALOG,
        /** Demo-step without accompanying information
          * which must not be used in testing scenarios.     5 */ stDEMO,
        /** Step created for auxiliary activities.           6 */ stUNDEFINED;
    }

}
