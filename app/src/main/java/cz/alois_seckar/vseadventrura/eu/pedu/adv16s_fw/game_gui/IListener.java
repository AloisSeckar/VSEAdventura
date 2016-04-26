/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;



/*******************************************************************************
 * Instance interfejsu {@code IListener} představují posluchače
 * očekávající nějakou událost.
 *
 * @param <Informant> Typ objektu poskytujícího informace o události,
 *                    na kterou posluchač čeká
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IListener<Informant>
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================
//== OTHER ABSTRACT METHODS ====================================================

    /***************************************************************************
     * Hlášeni o výskytu očekávané události.
     *
     * @param informant Objekt, který je schopen poskytnout informace
     *                  o události, kterou zavolání dané metody ohlašuje
     */
//    @Override
    public void notice(Informant informant)
    ;



//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
