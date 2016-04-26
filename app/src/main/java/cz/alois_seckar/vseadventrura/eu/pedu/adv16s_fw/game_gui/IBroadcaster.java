/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;



/*******************************************************************************
 * Instance interfejsu {@code IBroadcaster} představuji hlasatele
 * oznamujícího přihlášeným posluchačům výskyt události, na niž čekají.
 *
 * @param <Informant> Typ objektu obsahujícího informace o události,
 *                    kterou hlasatel oznamuje svým posluchačům
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IBroadcaster<Informant>
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================
//== OTHER ABSTRACT METHODS ====================================================

    /***************************************************************************
     * Přidá zadaného posluchače do seznamu posluchačů,
     * které zpravuje o výskytu očekávané události.
     *
     * @param listener Přihlašovaný posluchač
     */
//    @Override
    public void addListener(IListener<Informant> listener)
    ;


    /***************************************************************************
     * Odebere zadaného posluchače ze seznamu posluchačů,
     * které zpravuje o výskytu očekávané události.
     *
     * @param listener Odhlašovaný posluchač
     */
//    @Override
    public void removeListener(IListener<Informant> listener)
    ;



//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
