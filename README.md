# Random Spotify lejátszási lista generátor

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
