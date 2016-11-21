require_relative 'Treasure.rb'
require_relative 'BadConsequence.rb'

class Player
  @@MAX_LEVEL = 10
  
  protected :MAX_LEVEL
  
  def self.MAX_LEVEL
    @@MAX_LEVEL
  end
  
  def initialize(name)
    @name = name
    @level = 0
    @dead = true
    @can_i_steal = true
    @enemy = nil
    @hidden_treasures = []
    @visible_treasures = []
    @pending_bad_consequence = nil    
  end

public  
  attr_reader :name, :level, :dead, :can_i_steal
  attr_writer :enemy

  def combat(m)
    
  end
  
  def get_combat_level
    combat_level = @level
    
    @visible_treasures.for_each { |t| combat_level += t.bonus }
    
    combat_level
  end
  
  def make_treasures_visible(t)
    
  end
  
  def discard_visible_treasure(t)
    
  end
  
  def discard_hidden_treasures(t)
    
  end
  
  def valid_state
    (@pending_bad_consequence == nil and @hidden_treasures.length <= 4)
  end
  
  def init_treasures
    
  end
  
  def steal_treasure
    
  end
  
private  
  def bring_to_life
    @dead = false
  end
  
  def increment_levels(l)
    @level += l
  end
  
  def decrement_levels(l)
    @level -= l
  end

  def set_pending_bad_consequence(b)
    @pending_bad_consequence = b
  end
  
  def apply_prize(m)
    
  end
  
  def apply_bad_consequence(m)
    
  end
  
  def can_make_treasures_visible(t)
    
  end
  
  def how_many_visible_treasures(t_kind)
    @visible_treasures.select { |t| t.kind == t_kind  }.length
  end
  
  def die_if_no_treasures()
    @visible_treasures.empty? and @hidden_treasures.empty?
  end
  
  def give_me_a_treasure
    
  end
  
  def can_you_give_me_a_treasure
    not @visible_treasures.empty? or not @hidden_treasures.empty?
  end
  
  def have_stolen
    @can_i_steal = false
  end
  
  def discard_all_treasures
    
  end
end
