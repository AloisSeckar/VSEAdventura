/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_txt.game;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionRead} instances process the commands
 * that are responsible for reading certain item.
 * In this game the paper or the magazine can be read.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionRead extends AAction
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
     * reading the paper or magazine (after checking the defined conditions).
     */
    ActionRead()
    {
        super (Texts.aREAD,
        "It verifies that the player holds the item he wants to read,\n"
      + "that this item is readable and the player has glasses on.\n"
      + "If these conditions are fulfilled, it reveals to the player \n"
      + "the text written at the given item.\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Reveals the text written at the given item to the player.
     * But before that it checks,
     * <ul>
     * <li>if the item that has to be read is given,</li>
     * <li>if this item is in the bag (i.e. if the player holds it),</li>
     * <li>if this item is readable (it has to be a paper or a magazine,</li>
     * <li>if the player has put the glasses on.</li>
     * </ul>
     *
     * @param //parameters Item the player wants to read
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_READING;                        //==========>
        }
        String      itemName = arguments[1];
        Hands          hands = DemoApartmentGame.getInstance().getBag();
        Optional<Item> oItem = hands.getOItem(itemName);
        if (! oItem.isPresent()) {
            return Texts.mNOT_IN_BAG;                        //==========>
        }
        String message;
        if (Texts.PAPER.equalsIgnoreCase(itemName)) {
            message = Texts.mWRITTEN_ON_PAPER;
        }
        else if (Texts.MAGAZINE.equalsIgnoreCase(itemName)) {
            message = Texts.mWRITTEN_IN_MAGAZINE;
        }
        else {
            return Texts.mNOT_READABLE + itemName;         //==========>
        }
        return Texts.mWANT_READ + oItem.get().getName() +
               (State.isGlassesPutOn()  ?  message  :  Texts.mNO_GLASS);
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
