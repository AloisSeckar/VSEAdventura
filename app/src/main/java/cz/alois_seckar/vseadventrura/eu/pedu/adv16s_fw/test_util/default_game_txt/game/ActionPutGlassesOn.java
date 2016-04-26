/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionHelp} instances process the commands
 * that induce the player puts on the glasses.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionPutGlassesOn extends AAction
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
     * Creates an action instance for
     * the player puts on the glasses.
     */
    ActionPutGlassesOn()
    {
        super (Texts.aPUT_ON,
        "It puts the given item on.\n"
      + "The item has to be glasses (nothing else can be put on)\n"
      + "and the player has to hold them in his hand in the \"bag\".\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Simulates putting the given item on. This object should be
     * the glasses, which has to be in the bag (in hand).
     *
     * @param arguments Parameters of the command
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_PUT_ON;
        }
        String         itemName = arguments[1];
        Optional<Item> oGlasses = Hands.getInstance().getOItem(itemName);
        if (! oGlasses.isPresent()) {
            return Texts.mNOT_IN_BAG + itemName;
        }
        if (Texts.GLASSES.equalsIgnoreCase(itemName)) {
            State.setGlassesPutOn(true);
            Hands.getInstance().removeItem(oGlasses.get());
            return Texts.mGLASS_PUT_ON;
        }
        else {
            return Texts.mNOT_PUTABLE + itemName;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
