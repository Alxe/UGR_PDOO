#encoding: utf-8

require 'singleton'

require 'Monster.rb'
require 'Treasure.rb'

class CardDealer
  include Singleton
  
  def initialize
    @used_monsters = []
    @used_treasures = []
    @unused_monsters = []
    @unused_treasures = []
  end
  
  attr_reader :unused_monsters, :unused_treasures
  

  def init_treasure_card_deck
    @unused_treasures = [
      Treasure.new("¡Si, mi amo!", 4, TreasureKind::HELMET),
      Treasure.new("Botas de investigación", 3, TreasureKind::SHOES),
      Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET),
      Treasure.new("A prueba de balas", 2, TreasureKind::ARMOR),
      Treasure.new("Botas de lluvia ácida", 1, TreasureKind::BOTHHANDS),
      Treasure.new("Casco minero", 2, TreasureKind::HELMET),
      Treasure.new("Ametralladora ACME", 4, TreasureKind::BOTHHANDS),
      Treasure.new("Camiseta de la ETSIIT", 1, TreasureKind::ARMOR),
      Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND),
      Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND),
      Treasure.new("Fez alópodo", 3, TreasureKind::HELMET),
      Treasure.new("Hacha prehistorica", 2, TreasureKind::ONEHAND),
      Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR),
      Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS),
      Treasure.new("Insecticida", 2, TreasureKind::ONEHAND),
      Treasure.new("Escopeta de tres cañones", 4, TreasureKind::BOTHHANDS),
      Treasure.new("Garabato mistico", 2, TreasureKind::ONEHAND),
      Treasure.new("La rebeca metalica", 2, TreasureKind::ARMOR),
      Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS),
      Treasure.new("Necro-comicon", 1, TreasureKind::ONEHAND),
      Treasure.new("Necronomicon", 5, TreasureKind::BOTHHANDS),
      Treasure.new("Linterna a dos manos", 3, TreasureKind::BOTHHANDS),
      Treasure.new("Necro-gnomicon", 2, TreasureKind::ONEHAND),
      Treasure.new("Necrotelecom", 2, TreasureKind::HELMET),
      Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND),
      Treasure.new("Necro-playboycon", 3, TreasureKind::ONEHAND),
      Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND),
      Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS),
      Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND),
      Treasure.new("Tentaculo de pega", 2, TreasureKind::HELMET),
      Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
    ]
  end
  
  def init_monster_card_deck
    @unused_monsters = [
      Monster.new("3 Byakhees de bonanza", 8,
              Prize.new(2, 1), 
              BadConsequence.new_level_specific_treasures("Pierdes tu armadura visible y otra oculta", 0, 
                [TreasureKind::ARMOR], [TreasureKind::ARMOR])),

      Monster.new("Tenochtitlan", 2,
              Prize.new(1, 1),
              BadConsequence.new_level_specific_treasures("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                [TreasureKind::HELMET], [])),

      Monster.new("El sopor de Dunwich", 2,
              Prize.new(1, 1),
              BadConsequence.new_level_specific_treasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                      [TreasureKind::SHOES], [])),

      Monster.new("Demonios de Magaluf", 2,
              Prize.new(4, 1),
              BadConsequence.new_level_num_treasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, 1, 1)),

      Monster.new("El gorrón en el umbral", 13,
              Prize.new(3, 1),
              BadConsequence.new_level_num_treasures("Pierdes todos tus tesoros visibles", 0, 0, 0)),

      Monster.new("H.P. Munchcraft", 6, 
              Prize.new(2, 1), 
              BadConsequence.new_level_specific_treasures("Pierdes la armadura visible", 0,
                      [TreasureKind::ARMOR], [])),

      Monster.new("Necrófago", 13, 
              Prize.new(1, 1), 
              BadConsequence.new_level_specific_treasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0, 
                      [TreasureKind::ARMOR], [])),

      Monster.new("El rey de rosado", 11, 
              Prize.new(3, 2), 
              BadConsequence.new_level_num_treasures("Pierdes 5 niveles de 3 tesoros visibles", 5, 3, 0)),

      Monster.new("Flecher", 2, 
              Prize.new(1, 1), 
              BadConsequence.new_level_num_treasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)),

      Monster.new("Los hondos", 8, 
              Prize.new(2, 1), 
              BadConsequence.new_death("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto")),

      Monster.new("Semillas Cthulhu", 4, 
              Prize.new(2, 1), 
              BadConsequence.new_level_num_treasures("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)),

      Monster.new("Dameargo", 1, 
              Prize.new(2, 1), 
              BadConsequence.new_level_specific_treasures("Te intentas escaquear. Pierdes una mano visible.", 0,
                [TreasureKind::ONEHAND], [])),

      Monster.new("Pollipólipo volante", 3, 
              Prize.new(2, 1), 
              BadConsequence.new_level_num_treasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)),

      Monster.new("Yskhtihyssg-Goth", 14, 
              Prize.new(3, 1), 
              BadConsequence.new_death("No le hace gracia que pronuncien mal su nombre. Estas muerto")),

      Monster.new("Familia feliz", 1, 
              Prize.new(3, 1), 
              BadConsequence.new_death("La familia te atrapa. Estás muerto.")),

      Monster.new("Roboggoth", 8, 
              Prize.new(2, 1), 
              BadConsequence.new_level_specific_treasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                [TreasureKind::BOTHHANDS], [])),

      Monster.new("El espía sordo", 5, 
              Prize.new(1, 1), 
              BadConsequence.new_level_specific_treasures("Te asusta en la noche", 0,
                [TreasureKind::HELMET], [])),

      Monster.new("Tongue", 19, 
              Prize.new(2, 1), 
              BadConsequence.new_level_num_treasures("Menudo susto te llevas", 2, 5, 0)),

      Monster.new("Bicéfalo", 21, 
              Prize.new(2, 1), 
              BadConsequence.new_level_num_treasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, 100000, 0)),
    ]
  end
  
  def shuffle_treasures
    @unused_treasures.shuffle!
  end
  
  def shuffle_monsters
    @unused_monsters.shuffle!
  end
 
public
  def give_treasure_back(t)
    @used_treasures.push(t)
  end
  
  def give_monster_back(m)
    @used_monsters.push(m)
  end
  
  def init_cards
    init_monster_card_deck
    init_treasure_card_deck
  end
  
  def next_monster
    
  end
  
  def next_treasure
    
  end
  
end
