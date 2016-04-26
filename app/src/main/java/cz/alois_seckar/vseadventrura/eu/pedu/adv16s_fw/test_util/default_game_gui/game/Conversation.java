/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import org.joda.time.LocalDate;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities.Function;

import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game.Texts.*;



/*******************************************************************************
 * The {@code Conversation} class defines the code holding a conversation with
 * the user. When holding it the whole system is in a special state,
 * in which processing of texts given by the user is modified.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Conversation
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The lowest acceptable age. */
    private static final int LOW_AGE = 5;

    /** The highest acceptable age. */
    private static final int HIGH_AGE = 105;



//== VARIABLE CLASS FIELDS =====================================================

    /** The alcoholic drink that the player wants to take from the ice-box
     *  and for which the whole conversation is held. */
    private static Item drink;

    /** The variable referring to the function responsible for the reaction
     *  on the player answer at the given conversation state. */
    private static Function<String, String> stateDependentAnswer;

    /** The player age given at the first conversation phase.
     *  In the second phase it will be compared with the given birth year. */
    private static int age;



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Method solving the reaction to player answers within the conversation.
     *
     * @param command The player answer to the previous question
     * @return The game answer to the player
     */
    static String answer(String command)
    {
        return stateDependentAnswer.apply(command);
    }


    /***************************************************************************
     * Starts the conversation on impossibility to take the object,
     * that is an alcoholic drink.
     *
     * @param drink The object that the player wants to take from the ice-box
     * @return The first part of the conversation said by the ice-box
     */
    static String start(Item drink)
    {
        State.setConversation(true);
        Conversation.  drink = drink;
        String     drinkName = drink.getName();
        stateDependentAnswer = Conversation::waitingForTheAge;
        return Texts.mTAKES_ALCOHOL + drinkName + "." + Texts.mHOW_OLD;
//             "You try to take from an intelligent ice-box " + drinkName +
//             "This ice-box does not enable serving of alcoholic drinks " +
//             "to under-agers.\nWhat is your age?");
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================

    /***************************************************************************
     * Method solving the game reaction to user answers in the conversation
     * first stage, when the user has to enter his age.
     *
     * @param userAnswer The user answer
     * @return The game answer to the player
     */
    private static String waitingForTheAge(String userAnswer)
    {
        try {
            age = Integer.parseInt(userAnswer);
            if ((age < LOW_AGE)  ||  (HIGH_AGE < age)) {
                throw new NumberFormatException();
            }
        }catch(NumberFormatException nfe) {
            return String.format(fWRONG_INTEGER + fNOT_ALLOWED + fONCE_MORE,
                                 fAGE, LOW_AGE, HIGH_AGE);
        }
        if (age < 18) {
            State.setConversation(false);
            return String.format(fTOO_LOW + fNOT_ALLOWED, drink.getName());
        }
        stateDependentAnswer = Conversation::waitingForTheYear;
        return mBIRTH;
            // "In which year you were born?";
    }


    /***************************************************************************
     * Method solving the game reaction to user answers in the conversation
     * second stage, when the user has to enter his birth year.
     *
     * @param userAnswer The user answer
     * @return The game answer to the player
     */
    private static String waitingForTheYear(String userAnswer)
    {
        int year;
        try {
            year = Integer.parseInt(userAnswer);
        }catch(NumberFormatException nfe) {
            return String.format(fWRONG_INTEGER + fONCE_MORE, fYEAR);
        }
        State.setConversation(false);

        int thisYear   = LocalDate.now().getYear();
        int countedAge = thisYear - year;
        if (Math.abs(age - countedAge) > 1) {
            return String.format(fDOES_NOT_MATCH + fNOT_ALLOWED,
                                 age, year, drink.getName());
        }
        State.setMajor(true);
        Apartment.getInstance().getCurrentSpace().removeItem(drink);
        Hands    .getInstance().tryAddItem(drink);
        return mBELIEVE + mTAKEN_FROM_IB + drink.getName() + mDO_NOT_FORGET;
    }



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     *
     */
    private Conversation()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
