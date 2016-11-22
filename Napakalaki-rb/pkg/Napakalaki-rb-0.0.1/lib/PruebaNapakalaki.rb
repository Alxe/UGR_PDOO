#encoding: utf-8

require_relative 'TreasureKind.rb'
require_relative 'Monster.rb'
require_relative 'CardDealer.rb'

module PruebaNapakalaki
  
  def self.monstruos_con_nivel_mayor_a_diez
    @@monstruos.select { |m| m.combatLevel > 10 }
  end
  
  def self.monstruos_con_mal_rollo_niveles
    @@monstruos.select { |m| 
      m.bc.nVisibleTreasures == 0 and
        m.bc.nHiddenTreasures == 0 and
        m.bc.specificVisibleTreasures.empty? and
        m.bc.specificHiddenTreasures.empty?
    }
  end
  
  def self.monstruos_con_mal_rollo_de_nivel_uno
    @@monstruos.select { |m|
      m.prize.level > 1
    }
  end
  
  def self.monstruos_consulta_4(treasure_kind)
    @@monstruos.select { |m|
      m.bc.specificVisibleTreasures.include?(treasure_kind) or
        m.bc.specificHiddenTreasures.include?(treasure_kind)
    }
  end

  def self.main
    puts monstruos_consulta_4(TreasureKind::ARMOR)
    puts monstruos_con_nivel_mayor_a_diez
    puts monstruos_con_mal_rollo_niveles
    puts monstruos_con_mal_rollo_de_nivel_uno
    puts monstruos_consulta_4(TreasureKind::ONEHAND)
    puts monstruos_consulta_4(TreasureKind::BOTHHANDS)
    puts monstruos_consulta_4(TreasureKind::HELMET)
    puts monstruos_consulta_4(TreasureKind::SHOES)
    puts monstruos_consulta_4(TreasureKind::ARMOR)
  end
  
  #start init
  @@dealer = CardDealer.instance
  @@dealer.init_cards
  @@monstruos = @@dealer.unused_monsters
  #end init
end

PruebaNapakalaki::main