# Oppgavesett: `Liquid` - håndtering av væske

I denne oppgaven skal du opprette et system som håndterer væsker. Dette vil si at vi skal representere væsker og beholdere som inneholder 1 eller flere typer væske. Se for deg en vannflaske eller en bøtte med såpevann.

## Opgpaver

- a) Opprett en abstrakt klasse med navn `Liquid`

---

- b) Opprett en indre klasse i `Liquid`-klassen som heter `Amount`

---

- c) I klassen `Liquid.Amount` opprett følgende felt:
  - `private double volume` (Liter)
  - `private Liquid liquid`
    
  Videre så skal du opprette gettere og settere for disse feltene.

---

- d) I klassen `Liquid` opprette følgende felter:
  -  `private String name`

  Opprett getter og setter for dette feltet

---

- e) Opprett en indre klasse i klassen `Liquid` som heter `Container`

---

- f) I klassen `Liquid.Container` sopprett følgende felt:
  - `private double capacity` (Liter) 
  - `private ArrayList<Liquid.Amount> content`

  Opprett og implementer følgende metoder:
    - `boolean isAtCapacity()`
    - `ArrayList<Liquid> getLiquids()`
    - `double getTotalVolume()`
    - `double getVolumeOfLiquid(Liquid liquid)`
    - `Liquid getSmallestLiquid()`
    - `Liquid getLargestLiquid()`
    - `void add(double volume, Liquid liquid)`
    - `void add(Liquid.Amount liquidAmount)`
    - `void remove(Liquid liquid)`
    - `void remove(double volume, Liquid liquid)`
    - `void empty()`

- g) I følgende situasjoner:
  - Det legges til en væske som gjør at beholder overstiger sin kapasitet
  - Det fjernes mer av en væske enn det er i beholderen
  - Det forsøkes å hente ut volumet til en væske som ikke befinner seg i beholderen
  
  Så skal det kastes en `Exception` som forklarer situasjonen med en feilmelding

---

Fortsettelse følger ...