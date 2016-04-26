/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IWorld;

import java.util.Collection;



/*******************************************************************************
 * An instance of the {@code IWorld} interface represents the game world.
 * It should be defined as a singleton.
 * It is responsible for arrangement of individual spaces and keeps information,
 * in which space the player is just situated.
 * The mutual arrangement may change during the game,
 * the spaces can gain and/or lose their neighbors.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IWorldG
         extends IWorld
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of all spaces of the game.
     *
     * @return Collection of all spaces performing in the game
     */
    @Override
    public Collection<? extends ISpaceG> getAllSpaces()
    ;


    /***************************************************************************
     * Returns the current space,
     * i.e. to the space in which the player is just situated.
     *
     * @return The space in which the player is just situated
     */
    @Override
    public ISpaceG getCurrentSpace()
    ;



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
