/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.INamed;

import com.annimon.stream.Optional;



/*******************************************************************************
 * {@code ActionGoTo} instances process the commands
 * that move the player from the current space to the given neighboring one.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class ActionGoTo extends AAction
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
     * Creates the action instance for
     * moving the player from the current space to the given neighboring one.
     */
    ActionGoTo()
    {
        super (Texts.aGOTO,
        "It moves the player to the neighboring room given in an argument.\n"
      + "But it requires so that this room would be a neighbor "
      + "of the current room,\n"
      + "Otherwise nothing will be done "
      + "and the error message will be reported.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Moves the player into the space (room) given in an argumenant.
     * Requires that this space has to be a neighbor of the current space,
     * otherwise nothing will be done and the command is reported as wrong.
     *
     * @param arguments Parameter of the command
     * @return The message text written after accomplishing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return Texts.mNO_TARGET;
        }
        String destinationName = arguments[1];
        Room   currentRoom     = Apartment.getInstance().getCurrentSpace();
        Optional<Room> oDestination = INamed.getO(destinationName,
                                                  currentRoom.getNeighbors());
        if (! oDestination.isPresent()) {
            return Texts.mNOT_NEIGHBOR + destinationName;
        }
        Room destinationRoom = oDestination.get();
        Apartment.getInstance().setCurrentSpace(destinationRoom);
        return Texts.mMOVED + destinationRoom.getName();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
