/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionUnderlayIcebox} instances process the commands
 * that have to underlay the given item with the given item.
 * In this game the supported item is always the ice-box in the kitchen,
 * but generally the game can be extended by supporting other items
 * in other spaces.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionUnderlayIcebox extends AAction
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
     * moving of opening the item that can be opened
     * (after checking the defined conditions)
     * and after opening it becomes a current space.
     */
    ActionUnderlayIcebox()
    {
        super (Texts.aUNDERLAY,
        "It underlaid the given item with the given item.\n"
      + "So that the command would work, "
      + "the first argument has to be an ice-box,\n"
      + "that has to be located in the current room,\n"
      + "that the second argument has to be a magazine,\n"
      + "which has to be located in the bag (the player has to hold it)\n"
      + "and that the player has one hand free "
      + "to be able to raise the ice-box.\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Underlays the item given in the first argument
     * with the item given in the second argument.
     * Before that it checks,
     * <ul>
     * <li>if the item that should be underlaid is given,</li>
     * <li>if the item serving as a underlayment is given,</li>
     * <li>if the item being underlaid is in the current space,</li>
     * <li>if the underlying item (the underlayment) is in the bag
     *     (=in the player's hand),</li>
     * <li>if the item being underlaid is the ice-box,</li>
     * <li>if the underlying item (the underlayment) is the magazine.</li>
     * </ul>
     *
     * @param //parameters The only allowed arguments are up-to-now
     *                   the "ice-box" as the first one
     *                   and the "magazine" as the second one
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mWHAT_UNDERLAY;
        }
        if (arguments.length < 3) {
            return Texts.mUNDERLAY_WITH;
        }
        String nameUnderlaid  = arguments[1];
        String nameUnderlying = arguments[2];
        String message1       = Texts.mWANT_UNDERLAY + nameUnderlaid  +
                                Texts.mWITH_ITEM     + nameUnderlying + '.';
        String messageErr     = message1 + '\n';
        Room   currentRoom    = Apartment.getInstance().getCurrentSpace();
        Hands  hands          = Hands.getInstance();

        Optional<Item> oUnderlaiddObject = currentRoom.getOItem(nameUnderlaid);
        Optional<Item> oUnderlyingObject = hands.getOItem(nameUnderlying);

        if (! oUnderlaiddObject.isPresent()) {
            return messageErr + Texts.mNO_UNDERLAID + nameUnderlaid;
        }
        if (! oUnderlyingObject.isPresent()) {
            return messageErr + Texts.mNO_UNDERLAYMENT + nameUnderlaid;
        }
        if (! Texts.ICE_BOX.equalsIgnoreCase(nameUnderlaid)) {
            return messageErr + Texts.mNOT_UNDERLAYABLE + nameUnderlaid;
        }
        else if (Texts.MAGAZINE.equalsIgnoreCase(nameUnderlaid)) {
            return messageErr + Texts.mNOT_USABLE + nameUnderlying;
        }
        else if (hands.isFull()) {
            return messageErr + Texts.mNOT_CAPABLE;
        }
        else {
            hands.removeItem(oUnderlyingObject.get());
            State.setIceboxUnderlaid(true);
            return message1 + Texts.mICEBOX_UNDERLAID;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
