/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGame;

import java.net.URL;



/*******************************************************************************
 * Instance interfejsu {@code IGameG} mají na starosti logiku hry.
 * Jsou schopny akceptovat jednotlivé příkazy a poskytovat informace
 * o průběžném stavu hry a jejích součástech.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IGameG
         extends IGame, IGSMFactoryProductG
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    //Metody her implementujících tento interfejs musejí vracet instance,
    //resp. kolekce instancí implementujících interfejs v tomto balíčku
    //Proto je třeba je tu deklarovat znovu. protože deklarované
    //návratové hodnoty jsou potomky návratových hodnot metod rodiče

    /***************************************************************************
     * Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané předměty.
     *
     * @return Požadovaný odkaz
     */
    @Override
    public IBagG getBag()
    ;


    /***************************************************************************
     * Vrátí URL adresu stránky s nápovědou.
     *
     * @return URL adresa stránky s nápovědou
     */
//    @Override
    public URL getHelpURL()
    ;


    /***************************************************************************
     * Vrátí obrázek s plánkem prostoru, v němž se hraje.
     *
     * @return Obrázek s plánkem prostoru
     */
//    @Override
    public String getMap()
    ;


    /***************************************************************************
     * Vrátí obrázek hráče, který bude zobrazován na plánku hry,
     * aby uživatel věděl, ve kterém prostoru se jeho hráč aktuálně nachází.
     *
     * @return Obrázek hráče
     */
//    @Override
    public String getPlayer()
    ;


    /***************************************************************************
     * Vrátí odkaz na svět, v němž se hra odehrává.
     *
     * @return Svět, v němž se hra odehrává
     */
    @Override
    public IWorldG getWorld()
    ;



//== OTHER ABSTRACT METHODS ====================================================

    /***************************************************************************
     * Přidá zadaného posluchače do seznamu posluchačů,
     * které informuje o změně množiny objektů v batohu.
     *
     * @param bagListener Přihlašovaný posluchač
     */
//    @Override
    public void addBagListener(IListener<IBagG> bagListener)
    ;


    /***************************************************************************
     * Odebere zadaného posluchače ze seznamu posluchačů,
     * které informuje o změně množiny objektů v batohu.
     *
     * @param bagListener Odhlašovaný posluchač
     */
//    @Override
    public void removeBagListener(IListener<IBagG> bagListener)
    ;


    /***************************************************************************
     * Přidá zadaného posluchače do seznamu posluchačů,
     * které informuje o změně množiny objektů v aktuální prostoru.
     *
     * @param objectListener Přihlašovaný posluchač
     */
//    @Override
    public void addItemListener(IListener<ISpaceG> objectListener);


    /***************************************************************************
     * Odebere zadaného posluchače ze seznamu posluchačů,
     * které informuje o změně množiny objektů v aktuálním prostoru.
     *
     * @param objectListener Odhlašovaný posluchač
     */
//    @Override
    public void removeItemListener(IListener<ISpaceG> objectListener);


    /***************************************************************************
     * Přidá zadaného posluchače do seznamu posluchačů,
     * které informuje o změně množiny sousedů aktuálního prostoru.
     *
     * @param neighborsListener Přihlašovaný posluchač
     */
//    @Override
    public void addNeighborsListener(IListener<ISpaceG> neighborsListener)
    ;


    /***************************************************************************
     * Odebere zadaného posluchače ze seznamu posluchačů,
     * které informuje o změně množiny sousedů aktuálního prostoru.
     *
     * @param neighborsListener Odhlašovaný posluchač
     */
//    @Override
    public void removeNeighborsListener(IListener<ISpaceG> neighborsListener)
    ;


    /***************************************************************************
     * Přidá zadaného posluchače do seznamu posluchačů,
     * kterým hra oznamuje začátek a konec rozhovoru.
     *
     * @param dialogListener Přihlašovaný posluchač
     */
//    @Override
    public void addDialogListener(IListener<Boolean> dialogListener)
    ;


    /***************************************************************************
     * Odebere zadaného posluchače ze seznamu posluchačů,
     * kterým hra oznamuje začátek a konec rozhovoru.
     *
     * @param dialogListener Odhlašovaný posluchač
     */
//    @Override
    public void removeDialogListener(IListener<Boolean> dialogListener)
    ;



//== DEFAULT GETTERS AND SETTERS ===============================================



//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
