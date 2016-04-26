/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IItemContainer;

import java.util.Collection;



/*******************************************************************************
 * Instance interfejsu {@code IItemContainerG} představují kontejnery,
 * které mohou obsahovat objekty vystupující ve hře.
 * Speciálními případy těchto kontejnerů jsou prostory a batohy.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IItemContainerG
         extends IItemContainer

{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném kontejneru.
     * Oproti rodičovské metodě vrací kolekci objektů implementujících
     * interfejs {@link IItemG}.
     *
     * @return Kolekce objektů nacházejících se v daném kontejneru
     */
    @Override
    public Collection<? extends IItemG> getItems()
    ;



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
