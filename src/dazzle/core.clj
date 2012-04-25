(ns dazzle.core
  (:use quil.core))

(defn get-current-directory []
  (. (java.io.File. "src/dazzle/map.png") getCanonicalPath))

(def mapimage (atom nil))

(defn setup []
  (smooth)                          ;;Turn on anti-aliasing
  (frame-rate 1)                    ;;Set framerate to 1 FPS
  )

                                    ;;  a nice shade of grey.
(def locations
  '((AL 439 270)
    (AK 94 325)
    (AZ 148 241)
    (AR 368 247)
    (CA 56 176)
    (CO 220 183)
    (CT 576 120)
    (DE 556 166)
    (FL 510 331)
    (GA 478 267)
    (HI 232 380)
    (ID 143 101)
    (IL 405 168)
    (IN 437 165)
    (IA 357 147)
    (KS 302 194)
    (KY 453 203)
    (LA 371 302)
    (ME 595 59)
    (MD 538 162)
    (MA 581 108)
    (MI 446 120)
    (MN 339 86)
    (MS 406 274)
    (MO 365 197)
    (MT 194 61)
    (NE 286 151)
    (NV 102 157)
    (NH 580 89)
    (NJ 561 143)
    (NM 208 245)
    (NY 541 107)
    (NC 519 221)
    (ND 283 65)
    (OH 472 160)
    (OK 309 239)
    (OR 74 86)
    (PA 523 144)
    (RI 589 117)
    (SC 506 251)
    (SD 286 109)
    (TN 441 229)
    (TX 291 299)
    (UT 154 171)
    (VT 567 86)
    (VA 529 189)
    (WA 92 38)
    (WV 496 178)
    (WI 392 103)
    (WY 207 125)))

(defn draw []
  (background 255)
  (image (load-image "map.png")  0 0)
  (fill (lerp-color 0x296f34 0x61e2f0 0.5))
  (doall (map (fn [[state x y]]
                (let [r (random (* 10 (rand)))]
                  (ellipse x y r r)))
              locations)))


(defsketch example                  ;;Define a new sketch named example
  :title "Oh so many grey circles"  ;;Set the title of the sketch
  :setup setup                      ;;Specify the setup fn
  :draw draw                        ;;Specify the draw fn
  :size [640 400])                  ;;You struggle to beat the golden ratio
