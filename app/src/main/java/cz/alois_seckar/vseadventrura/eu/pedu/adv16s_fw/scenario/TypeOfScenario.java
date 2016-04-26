/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario;



/*******************************************************************************
 * {@code TypeOfScenario} instances represent various types of scenario.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public enum TypeOfScenario
{
//== VALUES OF THE ENUMERATION TYPE ============================================

    /** Scenario defining the possible path to the goal
     *  and containing information for testing
     *  the game reaction to the entered commands.
     *  Each scenario manager has to offer it.
     *  This scenario has to fulfill a set of requirements including:
     *  <ul>
     *  <li>minimal number of steps,</li>
     *  <li>minimal number of visited spaces,</li>
     *  <li>minimal number of various type of actions,</li>
     *  <li>incorporation of basic mandatory actions:
     *  <ul><li>moving to the neighboring space,</li>
     *      <li>taking an item in the current space,</li>
     *      <li>putting an item down in the current space.</li>
     *  </ul>
     *  <li>successful game finishing.</li>
     *  </ul>
     *  The scenario manager has to offer exactly one scenario of this type.
     */                                                                 scHAPPY,

    /** Scenario serving for testing the game reactions to the wrongly entered
     *  commands. It has to contain all types of steps with the
     *  {@code TypeOfStep.Subtype.stMISTAKE} subtype.
     *  Beside the steps testing the wrongly entered basic mandatory commands
     *  also the steps asking help and immediate game termination belongs here.
     *  The scenario manager has to offer exactly one scenario of this type.
     */                                                              scMISTAKES,

    /** General scenario allowing testing the game behavior
     *  and not comming under previous two types.
     *  To be testable, this scenario must not contain any step
     *  of the {@link TypeOfStep#tsDEMO} type.
     *  The scenario manager can offer any number of scenarios of this type.
     */                                                               scGENERAL,

    /** Scenario serving only for demonstration of the possible path.
     *  Scenarios of this type do not allow standard game testing.
     *  This scenario may contain steps of any type.
     *  The scenario manager can offer any number of scenarios of this type.
     */                                                                  scDEMO;



//##############################################################################
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
     *
     */
    private TypeOfScenario()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
