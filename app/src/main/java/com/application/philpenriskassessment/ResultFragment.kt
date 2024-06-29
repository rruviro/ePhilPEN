package com.application.philpenriskassessment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)

        val bundleAge = requireArguments().getString("age")!!.toInt()
        val bundleSex = requireArguments().getString("sex")
        val bundleSbp = requireArguments().getString("sbp")!!.toInt()
        val bundleSmoker = requireArguments().getString("smoker")
        val bundleCholesterol = requireArguments().getString("cholesterol")!!.toInt()

//        algorithm
        if (bundleAge in 40..49 && bundleSmoker == "non-smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..159 && bundleCholesterol >= 155) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 160..179 && bundleCholesterol in 155..309) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp >= 180) {
                when (bundleCholesterol) {
                    in 155..230 -> {
                        binding.results.setBackgroundColor(Color.YELLOW)
                    }
                    in 231..270 -> {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                    in 271..309 -> {
                        binding.results.setBackgroundColor(Color.RED)
                    }
                    else -> {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    }
                }
            }
        } else if (bundleAge in 40..49 && bundleSmoker == "smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..159 && bundleCholesterol >= 155) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 155..309) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol >= 310) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                } else {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                }
            } else if (bundleSbp >= 180) {
                if (bundleCholesterol in 155..190) {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else if (bundleCholesterol in 191..230) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.RED)
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol in 231..270) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    } else {
                        binding.results.setBackgroundColor(Color.RED)
                    }
                } else if (bundleCholesterol >= 271) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            }
        } else if (bundleAge in 50..59 && bundleSmoker == "non-smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..139 && bundleCholesterol >= 155) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 140..159 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            }  else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp >= 180) {
                if ((bundleSex == "Male" || bundleSex == "Female") && bundleCholesterol in 155..190) {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else if (bundleCholesterol in 191..230) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    } else {
                        binding.results.setBackgroundColor(Color.YELLOW)
                    }
                } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleCholesterol in 231..270) {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleCholesterol in 271..309) {
                    binding.results.setBackgroundColor(Color.RED)
                } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleCholesterol >= 271) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            }
        } else if (bundleAge in 50..59 && bundleSmoker == "smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..139 && bundleCholesterol >= 155) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 155..270) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 271..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if (bundleSbp in 140..159 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 160..179 && bundleCholesterol in 160..179) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 160..179 && bundleCholesterol in 191..230) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 160..179 && bundleCholesterol in 231..270) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if (bundleSbp in 160..179 && bundleCholesterol in 271..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                } else {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                }
            } else if (bundleSbp >= 180) {
                if (bundleCholesterol in 155..190) {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else if (bundleCholesterol in 191..230) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.RED)
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol in 231..270) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    } else {
                        binding.results.setBackgroundColor(Color.RED)
                    }
                } else if (bundleCholesterol >= 271) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            }
        } else if (bundleAge in 60..69 && bundleSmoker == "non-smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..139 && bundleCholesterol >= 155) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 271..309) {
                binding.results.setBackgroundColor(Color.GREEN)
            }else if (bundleSbp in 140..159 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            }  else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp >= 180) {
                if ((bundleSex == "Male" || bundleSex == "Female") && bundleCholesterol in 155..190) {
                    binding.results.setBackgroundColor(Color.GREEN)
                } else if (bundleCholesterol in 191..309) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.YELLOW)
                    } else {
                        binding.results.setBackgroundColor(Color.GREEN)
                    }
                } else if (bundleCholesterol >= 310) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    } else {
                        binding.results.setBackgroundColor(Color.YELLOW)
                    }
                }
            }
        } else if (bundleAge in 60..69 && bundleSmoker == "smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..139 && bundleCholesterol in 155..190) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 120..139 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 155..230) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 231..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if (bundleSbp in 140..159 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 160..179 && bundleCholesterol in 160..179) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 160..179 && bundleCholesterol in 191..230) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 160..179 && bundleCholesterol in 231..270) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if (bundleSbp in 160..179 && bundleCholesterol in 271..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                } else {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                }
            } else if (bundleSbp >= 180) {
                if (bundleCholesterol in 155..190) {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else if (bundleCholesterol in 191..230) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.RED)
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol in 231..270) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    } else {
                        binding.results.setBackgroundColor(Color.RED)
                    }
                } else if (bundleCholesterol >= 271) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            }
        } else if (bundleAge in 70..79 && bundleSmoker == "non-smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..139 && bundleCholesterol in 155..309) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 120..139 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if (bundleSbp in 140..159 && bundleCholesterol in 191..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol >= 310) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if (bundleSbp in 160..179 && bundleCholesterol in 155..190) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 160..179 && bundleCholesterol in 191..230) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if (bundleSbp in 160..179 && bundleCholesterol in 231..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.RED)
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp >= 180) {
                if (bundleCholesterol in 155..190) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    } else {
                        binding.results.setBackgroundColor(Color.YELLOW)
                    }
                } else if (bundleCholesterol in 191..230) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.RED)
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol in 231..270) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol in 271..309) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    } else {
                        binding.results.setBackgroundColor(Color.RED)
                    }
                } else if (bundleCholesterol >= 310) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            }
        } else if (bundleAge in 70..79 && bundleSmoker == "smoker") {
            if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 120..139 && bundleCholesterol in 155..190) {
                binding.results.setBackgroundColor(Color.GREEN)
            } else if (bundleSbp in 120..139 && bundleCholesterol in 191..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol >= 310) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if ((bundleSex == "Male" || bundleSex == "Female") && bundleSbp in 140..159 && bundleCholesterol in 155..190) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else {
                    binding.results.setBackgroundColor(Color.GREEN)
                }
            } else if (bundleSbp in 140..159 && bundleCholesterol in 191..230) {
                binding.results.setBackgroundColor(Color.YELLOW)
            } else if (bundleSbp in 140..159 && bundleCholesterol in 231..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp in 140..159 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.RED)
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp in 160..179 && bundleCholesterol in 155..230) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else {
                    binding.results.setBackgroundColor(Color.YELLOW)
                }
            } else if (bundleSbp in 160..179 && bundleCholesterol in 231..309) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.RED)
                } else {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                }
            } else if (bundleSbp in 160..179 && bundleCholesterol >= 310) {
                if (bundleSex == "Male") {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                } else {
                    binding.results.setBackgroundColor(Color.RED)
                }
            } else if (bundleSbp >= 180) {
                if (bundleCholesterol in 155..190) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol in 191..230) {
                    if (bundleSex == "Male") {
                        binding.results.setBackgroundColor(Color.RED)
                    } else {
                        binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                    }
                } else if (bundleCholesterol >= 231) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            }
        }

        binding.home.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_referFragment)
        }

        return binding.root
    }

}

