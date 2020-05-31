# Random Spotify lejátszási lista generátor

## Frontend repository
Ennek a projectnek a frontend része ebben a repository-ban található: https://github.com/Adamage8/spoty_random_list_frontend

## Az feladat leírása

Készítsünk egy olyan alkalmazást, amely frontenden olyan felületet kínál, amely alkalmas a Spotify API-n keresztül egyedi lejátszási listákat generálni, amelyekhez a lent részletezett backend funkciókat alkalmazza.

## Funkcionális követelmények

- Új lejátszási listát készít, amit a következő (akár vegyes) bemenetekből származtat:
    - előadó
    - album
    - szám
    - lejátszási lista
- Ezeket százalékos arányban lehet állítani, hogy a generált listában hogy legyenek benne
- Ha a megadott százalékok nem töltik ki a 100-at, akkor hasonló zenékkel kitölti azt
- Időközönként a lista a rögzített feltételek megtartása mellett változik, újragenerálódik.
- A listák közül válogathatnak a felhasználók, és sajátjukként módosíthatják
- A felhasználók írhatnak megjegyzéseket az egyes listákhoz
- A felhasználók kérhetnek engedélyt, hogy a saját Spotify fiókjukhoz hozzátehessék más felhasználók listáit, és módosíthassák sajátjukként

## Nem funkcionális követelmények

- Spotify developer account megléte.
- A rendszernek könnyen használhatónak kell lennie.
- A legtöbb modern böngészőben működnie kell.

## Szakterületi fogalomjegyzék

- Spotify API: Szabványos, jól dokumentált függvények és eljárások halmaza a Spotify szerverein.

## Szerepkörök

- GitHub Repository karbantartása
- Fejlesztői megjegyzések
- Frontend
- Backend

## Fejlesztői környezet

- IntelliJ IDE
- H2 adatbázis
- Maven dependency manager
- Java Spring Boot

## Példa

Post Malone 40%

G-Easy 20%

Random 40%

## Végpontok

- GET users/
- GET users/{id}
- POST users/
- PATCH users/{id}
- GET compositions/
- GET compositions/{id}
- POST composition/
- PATCH composition/
- POST copy-requests/accept

## UML adatbázis terv

![adatbazis terv](https://raw.githubusercontent.com/Adamage8/spoty_random_list/master/uml.png)

# Fejlesztői környezet

## Frontend

- Használt IDE: PHPStorm JetBrains-től
- Használt nyelv: JavaScript
- Használt framework: AngularJS

A fejlesztés npm (Node package manager) parancsok segítségével automatizált. 

- development környezet futtatása:
    - npm start, ami meghívja az ng serve parancsot, ami az Angular keretrendszerhez tartozó command line interface
    - ez elindít egy szervert a [localhost](http://localhost:4200):4200-as porton, ahol hotloading technológia segíti a fejlesztést
- production környezet futtatása:
    - először fel kell építeni az alkalmazást "npm build" paranccsal
    - utána lehet futtatni a megfelelő környezetében
- A Spotify API használatával

### Könyvtárstruktúra

- root → tartalmazza a project konfigurációkat
    - src → source mappa
        - app → tartalmazza a komponenseket
        - assets → tartalmazza azokat a statikus fájlokat, amiket használ a kód futás közben
        - environments → fallback konfigurációk környezeti változókhoz
        - service → service-eket tartalmazó mappa
            - api → apihoz tartalmazó service-ek

## Backend

- Használt IDE: IntelliJ IDEA JetBrains-től
- Használt nyelv: Java
- Használt framework: Spring boot
- Maven package manager
- Futtatás: lefordítani és elindítani a projectet

### Könyvtárstruktúra

Az src mappán belül a com.adam.spotifygeneratedlists nevű package-ben található a részekre bontott szerkezet:

- controller → tartalmazza a használt kontrollereket
- entity → tartalmazza az entitásokat
- repository → tartalmazza a service-ekhez tartozó repository-kat
- service → service interface-eket tartalmazó package
    - implementation → tartalmazza a mappában található interface-eket megvalósító osztályok

# Szolgáltatások

- Média keresése Spotify API használatával
    - bizonyos kulcsszóval előadók, albumok és lejátszási listák keresése
- Lista összeállítása
    - névvel és listában szereplő dalok számával ellátva
    - meg lehet mondani, hogy egy kiválasztott lista hány százaléka legyen a generálandó listának
- Összeállítás paramétereivel generálni egyedi listát Spotify API-n keresztül
    - a bejelentkezett felhasználó Spotify fiókjába megjelenik egy új lista
- Megjegyzés fűzése összeállításokhoz
- Kijelentkezés

## Funkció bemutatása: Lista összeállítás

1. A felhasználó elnavigál a bejelentkezés oldalra
2. A felhasználó megnyomja a "Bejelentkezés Spotify-al" gombot
    1. A program átirányít a Spotify bejelentkező oldalára
    2. A felhasználó engedélyezi a megfelelő jogosultságokat
3. A program visszairányít az alkalmazás oldalra, megjegyezve a bejelentkezett felhasználót
4. A felhasználó elnavigál a "Összeállítás hozzáadása" oldalra
5. A felhasználó a média kereső mezőbe beírja a kigondolt lista kereső szavát, és megnyomja a Keres gombot
6. A program lekérdezi a Spotify API-ból az összes kulcsszónak megfelelő találatot, és kilistázza az oldalra
7. A listából a felhasználó kiválaszt egy elemet
8. A felhasználó kitölti a százalék mezőt, és rányom a "Hozzáad" gombra
9. A megfelő elem a megfelelő értékkel bekerül egy listába a mező alatt
10. Az 5-ös ponttól a 9-es pontig addig ismétli a felhasználó, amég nem ér el 100 százalékig
11. A felhasználó kitölti a név és elemszám mezőket
12. A felhasználó rányom a mentés gombra
13. A program elmenti a beállított paramétereket a szerverre
14. A program elnavigál az Összeállítások oldalra, ahol megjelenik az imént beállított lista

# Felhasználói dokumentáció

## Bejelentkezés

Bejelentkezéshez előfeltétel, hogy legyen Spotify fiókja regisztrálva, mert a rendszer azon keresztül végzi az authentikációt. 

## Lista összeállítása

- A létrehozásának működésének leírása a **"Funkció bemutatása: Lista összeállítás"** menüpontban
- ezeket lehet módosítani az "összeállítások" oldalon.
    - A törlés gombra kattintva kiszedi a listából és kitörli az adatbázisból egyszerre.
    - A módosítás gombra kattitva elvisz egy módosító oldalra, ahol minden változtatás után frissíti az eredeti entitást

## Lista generálás

Egy előkészített összeállítást le lehet generáltatni. Ezt az "összeállítások" oldalolon lehet megtenni. Mindegyik listaelemnél található egy "generálás" gomb, ami a Spotify API-n keresztül készít egy új listát a megadott paraméterekkel

## Megjegyzés fűzése

Az "összeállítások" oldalon minden összeállítás alatt van egy megjegyzés mező. A küldésre kattintva hozzáadja a megjegyzést

## Használati eset diagram
![hasznalati eset diagram](https://raw.githubusercontent.com/Adamage8/spoty_random_list/master/use_case.png)
